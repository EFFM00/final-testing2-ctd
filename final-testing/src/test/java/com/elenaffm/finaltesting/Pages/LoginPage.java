package com.elenaffm.finaltesting.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By usernameInput = By.name("username");

    By passwordInput = By.name("password");

    By btnLogin = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        WebElement usernameAux = driver.findElement(usernameInput);
        usernameAux.clear();
        usernameAux.sendKeys(username);

        WebElement passAux = driver.findElement(passwordInput);
        passAux.clear();
        passAux.sendKeys(password);
    }

    public void sendForm() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement btn = driver.findElement(btnLogin);
        btn.click();
    }

    public String checkMsg(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement msgResult = driver.findElement(locator);
        String text = msgResult.getText();

        return text;
    }

}
