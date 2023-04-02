package com.elenaffm.finaltesting.Pages;

import com.elenaffm.finaltesting.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    protected static By registerLink = By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");

    protected static By firstName = By.id("customer.firstName");
    protected static By lastName = By.id("customer.lastName");
    protected static By address = By.id("customer.address.street");
    protected static By city = By.id("customer.address.city");
    protected static By state = By.id("customer.address.state");
    protected static By zipCode = By.id("customer.address.zipCode");
    protected static By phone = By.id("customer.phoneNumber");
    protected static By ssn = By.id("customer.ssn");

    protected static By username = By.id("customer.username");
    protected static By password = By.id("customer.password");
    protected static By confirmPassword = By.id("repeatedPassword");

    protected static By btnRegister;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToRegisterPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement registryBtn = driver.findElement(registerLink);
        registryBtn.click();
    }



    public String checkMsg() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/h1")));
        WebElement msg = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1"));
        String text = msg.getText();

        return text;
    }


}
