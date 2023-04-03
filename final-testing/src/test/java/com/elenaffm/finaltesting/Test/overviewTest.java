package com.elenaffm.finaltesting.Test;

import com.elenaffm.finaltesting.Base.BasePage;
import com.elenaffm.finaltesting.Pages.LoginPage;
import com.elenaffm.finaltesting.Pages.OverviewPage;
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
    BasePage basePage;
    LoginPage loginPage;
    OverviewPage overviewPage;

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

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void comprobarInformacionCuenta() throws InterruptedException {
        overviewPage = new OverviewPage(driver);

        overviewPage.goToOverviewAccount();
        String textBalance = overviewPage.retornarTexto(overviewPage.getTextBalance());

        assertTrue(textBalance.contains("*Balance includes deposits that may be subject to holds"));

    }

    @Test
    public void comprobarDetallesCuenta() throws InterruptedException {
        overviewPage = new OverviewPage(driver);

        overviewPage.goToOverviewAccount();
        overviewPage.goToAccountDetails();

        String textBalance = overviewPage.retornarTexto(overviewPage.getTextDetails());

        assertTrue(textBalance.contains("Account Details"));

    }

}
