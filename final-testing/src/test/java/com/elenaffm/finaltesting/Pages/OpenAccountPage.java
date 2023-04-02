package com.elenaffm.finaltesting.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OpenAccountPage {

    WebDriver driver;
    WebDriverWait wait;
    By newAccountLink = By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[1]/a");
    By accountTypeInput = By.xpath("//*[@id=\"type\"]");
    By openNewAccountBtn = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input");
    By msgSuccess = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]");



    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToNewAccountPage() {
        WebElement newAccountLink = driver.findElement(this.newAccountLink);
        newAccountLink.click();
    }

    public void selectAccountType() throws InterruptedException {
        WebElement listOpt = driver.findElement(accountTypeInput);
        List<WebElement> options = listOpt.findElements(By.tagName("option"));

        for(int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals("SAVINGS")) {
                options.get(i).click();
            }
        }

        Thread.sleep(1000);

//        WebElement div = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div"));
//        WebElement btn = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div/input"));
//        div.click();
//        btn.click();
    }


    public String checkMsg() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(msgSuccess));
        WebElement msgResult = driver.findElement(msgSuccess);
        String text = msgResult.getText();

        return text;
    }

    public void sendFormNewAccount() {
        WebElement btn = driver.findElement(this.openNewAccountBtn);
        btn.click();
    }
}