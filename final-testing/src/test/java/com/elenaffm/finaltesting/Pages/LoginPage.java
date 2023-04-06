package com.elenaffm.finaltesting.Pages;

import com.elenaffm.finaltesting.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    WebDriverWait wait;

    By usernameInput = By.name("username");

    By passwordInput = By.name("password");

    By btnLogin = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        WebElement usernameAux = findElement(usernameInput);
        usernameAux.clear();
        usernameAux.sendKeys(username);

        WebElement passAux = findElement(passwordInput);
        passAux.clear();
        passAux.sendKeys(password);
    }

    public void sendForm() {
        wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(3));

        WebElement btn = findElement(btnLogin);
        btn.click();
    }

    public String checkMsg(By locator) {
        wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(3));

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement msgResult = findElement(locator);
        String text = msgResult.getText();

        return text;
    }

}
