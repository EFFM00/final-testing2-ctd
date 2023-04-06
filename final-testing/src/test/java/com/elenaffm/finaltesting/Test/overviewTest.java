package com.elenaffm.finaltesting.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.elenaffm.finaltesting.Base.BasePage;
import com.elenaffm.finaltesting.Pages.LoginPage;
import com.elenaffm.finaltesting.Pages.OverviewPage;
import com.elenaffm.finaltesting.reports.ExtentFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class overviewTest {

    private WebDriver driver;

    static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
    static ExtentReports extent;

    ExtentTest test;
    BasePage basePage;
    LoginPage loginPage;
    OverviewPage overviewPage;

    String username = "AnGomez43522";
    String password = "passTest12350";


    @BeforeAll
    public void setUp() {

        basePage = new BasePage(driver);

        driver = basePage.chromeDriverConnection();
        extent = ExtentFactory.getInstance();
        extent.attachReporter(spark);

        basePage.visit("https://parabank.parasoft.com/parabank/index.htm");

        test = extent.createTest("Apertura inicial de la página");

        loginPage = new LoginPage(driver);

        loginPage.login(username, password);
        loginPage.sendForm();


        String result = loginPage.checkMsg(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[8]/a"));

        assertTrue(result.contains("Log Out"));
        test.log(Status.PASS, "Login inicial");
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void comprobarInformacionCuenta() throws InterruptedException {
        overviewPage = new OverviewPage(driver);
        test = extent.createTest("Comprobar información de las cuentas");

        test.log(Status.INFO, "Inicio del test");

        overviewPage.goToOverviewAccount();
        test.log(Status.PASS, "Acceder a la sección de información de las cuentas");
        String textBalance = overviewPage.returnText(overviewPage.getTextBalance());

        test.log(Status.PASS, "Sección incluye el mensaje buscado");
        assertTrue(textBalance.contains("*Balance includes deposits that may be subject to holds"));

    }

    @Test
    public void comprobarDetallesCuenta() throws InterruptedException {
        overviewPage = new OverviewPage(driver);
        test = extent.createTest("Comprobar detalles de la cuenta");

        test.log(Status.INFO, "Inicio del test");

        overviewPage.goToOverviewAccount();
        overviewPage.goToAccountDetails();
        test.log(Status.PASS, "Acceder a la sección de detalles de las cuentas");

        String textBalance = overviewPage.returnText(overviewPage.getTextDetails());

        assertTrue(textBalance.contains("Account Details"));
        test.log(Status.PASS, "Sección incluye el mensaje buscado");

    }

}
