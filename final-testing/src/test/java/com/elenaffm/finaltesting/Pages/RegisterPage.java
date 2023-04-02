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

    protected static By btnRegister = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToRegisterPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement registryBtn = driver.findElement(registerLink);
        registryBtn.click();
    }


    public String checkMsg(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement msgResult = driver.findElement(locator);
        String text = msgResult.getText();

        return text;
    }


    public void completeForm(
            String firstNameIn,
            String lastNameIn,
            String addressIn,
            String cityIn,
            String stateIn,
            String zipCodeIn,
            String phoneIn,
            String ssnIn,
            String usernameIn,
            String passwordIn
    ) {

        WebElement nameAux = driver.findElement(firstName);
        nameAux.clear();
        nameAux.sendKeys(firstNameIn);

        WebElement lastnameAux = driver.findElement(lastName);
        lastnameAux.clear();
        lastnameAux.sendKeys(lastNameIn);

        WebElement addressAux = driver.findElement(address);
        addressAux.clear();
        addressAux.sendKeys(addressIn);

        WebElement cityAux = driver.findElement(city);
        cityAux.clear();
        cityAux.sendKeys(cityIn);

        WebElement stateAux = driver.findElement(state);
        stateAux.clear();
        stateAux.sendKeys(stateIn);

        WebElement zipCodeAux = driver.findElement(zipCode);
        zipCodeAux.clear();
        zipCodeAux.sendKeys(zipCodeIn);

        WebElement phoneAux = driver.findElement(phone);
        phoneAux.clear();
        phoneAux.sendKeys(phoneIn);

        WebElement ssnAux = driver.findElement(ssn);
        ssnAux.clear();
        ssnAux.sendKeys(ssnIn);

        WebElement usernameAux = driver.findElement(username);
        usernameAux.clear();
        usernameAux.sendKeys(usernameIn);

        WebElement passwordAux = driver.findElement(password);
        passwordAux.clear();
        passwordAux.sendKeys(passwordIn);

        WebElement confirmPassAux = driver.findElement(confirmPassword);
        confirmPassAux.clear();
        confirmPassAux.sendKeys(passwordIn);

    }


    public void sendForm() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement btn = driver.findElement(btnRegister);
        btn.click();
    }

}
