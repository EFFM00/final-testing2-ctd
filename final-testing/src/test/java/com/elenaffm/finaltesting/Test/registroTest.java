package com.elenaffm.finaltesting.Test;

import com.elenaffm.finaltesting.Base.BasePage;
import com.elenaffm.finaltesting.Pages.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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
        String result = registerPage.checkMsg();

        System.out.println(result);

        assertTrue(result.contains("Signing up is easy!"));
    }



}
