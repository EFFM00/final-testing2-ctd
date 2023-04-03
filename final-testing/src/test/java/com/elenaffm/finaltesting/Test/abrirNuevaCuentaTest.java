package com.elenaffm.finaltesting.Test;

import com.elenaffm.finaltesting.Base.BasePage;
import com.elenaffm.finaltesting.Pages.OpenAccountPage;
import com.elenaffm.finaltesting.Pages.LoginPage;
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
    BasePage basePage;
    LoginPage loginPage;
    OpenAccountPage openAccountPage;

    String username = "AnGomez4352";
    String password = "passTest12350";

    @BeforeAll
    public void setUp() {

        basePage = new BasePage(driver);

        driver = basePage.chromeDriverConnection();
        basePage.visit("https://parabank.parasoft.com/parabank/index.htm");

        loginPage = new LoginPage(driver);

        loginPage.login(username, password);
        loginPage.sendForm();

        String result = loginPage.checkMsg(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[8]/a"));

        assertTrue(result.contains("Log Out"));
    }

    @Test
    public void crearNuevaCuenta() throws InterruptedException {
        openAccountPage = new OpenAccountPage(driver);
        openAccountPage.goToNewAccountPage();
        openAccountPage.selectAccountType();
        openAccountPage.sendFormNewAccount();
        String result = openAccountPage.checkMsg();

        assertTrue(result.contains("Congratulations, your account is now open."));
    }


    @AfterAll
    public void tearDown() {
        driver.quit();
    }

}
