package com.elenaffm.finaltesting.Test;

import com.elenaffm.finaltesting.Base.BasePage;
import com.elenaffm.finaltesting.Pages.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class registroTest {

    private WebDriver driver;
    BasePage basePage;
    RegisterPage registerPage;

    @BeforeAll
    public void setUp() {

        basePage = new BasePage(driver);

        driver = basePage.chromeDriverConnection();
        basePage.visit("https://parabank.parasoft.com/parabank/index.htm");
    }

    @After
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
                "AnGomez9",
                "passTest12350"
        );

        registerPage.sendForm();
        String result = registerPage.checkMsg(By.xpath("/html/body/div[1]/div[3]/div[2]/p"));

        assertTrue(result.contains("Your account was created successfully. You are now logged in."));
    }



}
