package com.elenaffm.finaltesting.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TransferPage {


    WebDriver driver;
    WebDriverWait wait;
    By linkTransfer = By.xpath("//*[@id=\"leftPanel\"]/ul/li[3]/a");
    By amountInput = By.id("amount");

    By fromAccount = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[1]/select[2]/option[1]");
    By toAccount = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[1]/select[2]/option[4]");

    By btnSend = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[2]/input");

    By msgSuccess = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1");

    //By contMsgSuccess = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div");

    public TransferPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToNewAccountPage() throws InterruptedException {
        WebElement newAccountLink = driver.findElement(this.linkTransfer);
        newAccountLink.click();
        Thread.sleep(1000);
    }

    public String checkMsg() throws InterruptedException {
        Thread.sleep(2000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(msgSuccess));
        WebElement msgResult = driver.findElement(msgSuccess);
        String text = msgResult.getText();



        return text;
    }

    public void completeForm(){

        driver.findElement(amountInput).clear();
        driver.findElement(amountInput).sendKeys("120000");

        WebElement from = driver.findElement(fromAccount);
        WebElement to = driver.findElement(toAccount);

        from.click();
        to.click();
    }

    public void sendFormNewAccount() {
        WebElement btn = driver.findElement(this.btnSend);
        btn.click();
    }
}
