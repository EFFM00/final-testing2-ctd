package com.elenaffm.finaltesting.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.elenaffm.finaltesting.Pages.RegisterPage;
import com.elenaffm.finaltesting.reports.ExtentFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class registroTest {

    private WebDriver driver;

    static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
    static ExtentReports extent;

    ExtentTest test;
    RegisterPage registerPage;

    String username = "AnGomez43522";
    String password = "passTest12350";


    @BeforeAll
    public void setUp() {

        registerPage = new RegisterPage(driver);

        driver = registerPage.chromeDriverConnection();
        extent = ExtentFactory.getInstance();
        extent.attachReporter(spark);

        test = extent.createTest("Apertura inicial de la página");

        registerPage.visit("https://parabank.parasoft.com/parabank/index.htm");
        test.log(Status.INFO, "Acceder a la página");
    }

    @AfterAll
    public void tearDown() {
        extent.flush();
        driver.quit();
    }

    @Test
    public void abrirSeccionRegistro() {

        test = extent.createTest("Abrir sección registro");
        test.log(Status.INFO, "Inicio del test");

        registerPage.goToRegisterPage();
        test.log(Status.PASS, "Dirigirse a la sección de registro");
        String result = registerPage.checkMsg(By.xpath("//*[@id=\"rightPanel\"]/h1"));
        test.log(Status.PASS, "Formulario de registro abierto");

        assertTrue(result.contains("Signing up is easy!"));

    }

    @Test
    public void completarForm() {

        test = extent.createTest("Completando formulario registro");

        registerPage.goToRegisterPage();
        registerPage.completeForm(
                "Ana",
                "Gomez",
                "Av. Siempreviva",
                "Springfield",
                "Springfield",
                "1234",
                "32435234",
                "1",
                username,
                password
        );
        test.log(Status.INFO, "Datos completados");
        registerPage.sendForm();
        String result = registerPage.checkMsg(By.xpath("/html/body/div[1]/div[3]/div[2]/p"));

        test.log(Status.PASS, "Registro finalizado");
        assertTrue(result.contains("Your account was created successfully. You are now logged in."));
    }
}
