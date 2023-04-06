package com.elenaffm.finaltesting.Pages;

import com.elenaffm.finaltesting.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends BasePage{

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
        super(driver);
    }


    public void goToRegisterPage() {
        wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(3));

        WebElement registryBtn = findElement(registerLink);
        registryBtn.click();
    }


    public String checkMsg(By locator) {
        wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement msgResult = findElement(locator);
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

        WebElement nameAux = findElement(firstName);
        nameAux.clear();
        nameAux.sendKeys(firstNameIn);

        WebElement lastnameAux = findElement(lastName);
        lastnameAux.clear();
        lastnameAux.sendKeys(lastNameIn);

        WebElement addressAux = findElement(address);
        addressAux.clear();
        addressAux.sendKeys(addressIn);

        WebElement cityAux = findElement(city);
        cityAux.clear();
        cityAux.sendKeys(cityIn);

        WebElement stateAux = findElement(state);
        stateAux.clear();
        stateAux.sendKeys(stateIn);

        WebElement zipCodeAux = findElement(zipCode);
        zipCodeAux.clear();
        zipCodeAux.sendKeys(zipCodeIn);

        WebElement phoneAux = findElement(phone);
        phoneAux.clear();
        phoneAux.sendKeys(phoneIn);

        WebElement ssnAux = findElement(ssn);
        ssnAux.clear();
        ssnAux.sendKeys(ssnIn);

        WebElement usernameAux = findElement(username);
        usernameAux.clear();
        usernameAux.sendKeys(usernameIn);

        WebElement passwordAux = findElement(password);
        passwordAux.clear();
        passwordAux.sendKeys(passwordIn);

        WebElement confirmPassAux = findElement(confirmPassword);
        confirmPassAux.clear();
        confirmPassAux.sendKeys(passwordIn);

    }


    public void sendForm() {
        wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(3));

        WebElement btn = super.getDriver().findElement(btnRegister);
        btn.click();
    }

}
