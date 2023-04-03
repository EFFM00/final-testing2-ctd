package com.elenaffm.finaltesting.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.elenaffm.finaltesting.Base.BasePage;
import com.elenaffm.finaltesting.Pages.LoginPage;
import com.elenaffm.finaltesting.Pages.TransferPage;
import com.elenaffm.finaltesting.reports.ExtentFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class transferirFondos {

    private WebDriver driver;

    static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
    static ExtentReports extent;
    ExtentTest test;

    BasePage basePage;
    LoginPage loginPage;

    TransferPage transferPage;

    String username = "AnGomez43522";
    String password = "passTest12350";

    @BeforeAll
    public void setUp() {

        basePage = new BasePage(driver);

        driver = basePage.chromeDriverConnection();

        extent = ExtentFactory.getInstance();
        extent.attachReporter(spark);

        test = extent.createTest("Login previo transferencia fondos");

        basePage.visit("https://parabank.parasoft.com/parabank/index.htm");
        loginPage = new LoginPage(driver);

        loginPage.login(username, password);
        loginPage.sendForm();

        String result = loginPage.checkMsg(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[8]/a"));
        test.log(Status.PASS, "Login exitoso");

        assertTrue(result.contains("Log Out"));
    }

    @AfterAll
    public void tearDown() {
        extent.flush();
        driver.quit();
    }

    @Test
    public void transferirFondos() throws InterruptedException {
        test = extent.createTest("Inicio test transferencia de fondo");

        transferPage = new TransferPage(driver);
        transferPage.goToNewAccountPage();
        test.log(Status.INFO, "Dirigirse a la sección de transferencias");

        transferPage.completeForm();
        transferPage.sendFormNewAccount();
        test.log(Status.PASS, "Enviar formulario de transferencia");

        String result = transferPage.checkMsg();
        assertTrue(result.contains("Transfer Complete!"));
        test.log(Status.PASS, "Transferencia exitosa");
    }
}
