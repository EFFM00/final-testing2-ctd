package com.elenaffm.finaltesting.Test;

import com.elenaffm.finaltesting.Base.BasePage;
import com.elenaffm.finaltesting.Pages.LoginPage;
import com.elenaffm.finaltesting.Pages.RegisterPage;
import org.junit.After;
import org.junit.Before;
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
    BasePage basePage;
    RegisterPage registerPage;

    LoginPage loginPage;

    String username = "AnGomez452";
    String password = "passTest12350";


    @BeforeAll
    public void setUp() {

        basePage = new BasePage(driver);

        driver = basePage.chromeDriverConnection();
        basePage.visit("https://parabank.parasoft.com/parabank/index.htm");
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void abrirSeccionRegistro() {

        registerPage = new RegisterPage(driver);
        registerPage.goToRegisterPage();
        String result = registerPage.checkMsg(By.xpath("//*[@id=\"rightPanel\"]/h1"));

        assertTrue(result.contains("Signing up is easy!"));
    }

    @Test
    public void completarForm() {
        registerPage = new RegisterPage(driver);
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

        registerPage.sendForm();
        String result = registerPage.checkMsg(By.xpath("/html/body/div[1]/div[3]/div[2]/p"));

        assertTrue(result.contains("Your account was created successfully. You are now logged in."));
    }
}
