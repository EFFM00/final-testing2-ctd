package com.elenaffm.finaltesting.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.elenaffm.finaltesting.Base.BasePage;
import com.elenaffm.finaltesting.Pages.OpenAccountPage;
import com.elenaffm.finaltesting.Pages.LoginPage;
import com.elenaffm.finaltesting.reports.ExtentFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class abrirNuevaCuentaTest {

    private WebDriver driver;

    static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");

    static ExtentReports extent;

    ExtentTest test;

    LoginPage loginPage;
    OpenAccountPage openAccountPage;

    String username = "AnGomez43522";
    String password = "passTest12350";

    @BeforeAll
    public void setUp() {

        openAccountPage = new OpenAccountPage(driver);

        driver = openAccountPage.chromeDriverConnection();
        openAccountPage.visit("https://parabank.parasoft.com/parabank/index.htm");

        loginPage = new LoginPage(driver);

        loginPage.login(username, password);
        loginPage.sendForm();

        extent = ExtentFactory.getInstance();
        extent.attachReporter(spark);

        test = extent.createTest("Apertura inicial de la página");

        openAccountPage.visit("https://parabank.parasoft.com/parabank/index.htm");

        String result = loginPage.checkMsg(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[8]/a"));
        assertTrue(result.contains("Log Out"));

        test.log(Status.PASS, "Login inicial");

    }

    @Test
    public void crearNuevaCuenta() throws InterruptedException {

        test = extent.createTest("Crear una cuenta nueva");
        test.log(Status.INFO, "Inicio del test");
        openAccountPage = new OpenAccountPage(driver);

        openAccountPage.goToNewAccountPage();
        test.log(Status.PASS, "Dirigirse a la sección de apertura de cuenta");

        openAccountPage.selectAccountType();
        openAccountPage.sendFormNewAccount();
        test.log(Status.PASS, "Enviar formulario de creación");
        String result = openAccountPage.checkMsg();
        test.log(Status.PASS, "Verificación de mensaje de creación");

        assertTrue(result.contains("Congratulations, your account is now open."));
    }


    @AfterAll
    public void tearDown() {
        extent.flush();
        driver.quit();
    }

}
