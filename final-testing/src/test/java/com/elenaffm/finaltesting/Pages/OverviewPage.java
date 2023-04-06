package com.elenaffm.finaltesting.Pages;

import com.elenaffm.finaltesting.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage extends BasePage {

    By linkOverview = By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[2]/a");

    By textBalance = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/table/tfoot/tr/td");

    By columnAccount = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/table/tbody/tr[1]/td[1]/a");
    By textDetails = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/h1");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public void goToOverviewAccount() throws InterruptedException {
        WebElement newAccountLink = findElement(this.linkOverview);
        newAccountLink.click();
        Thread.sleep(1500);
    }

    public String returnText(By localizador) {
        WebElement text = findElement(localizador);

        return text.getText();
    }

    public void goToAccountDetails() throws InterruptedException {
        WebElement newAccountLink = findElement(this.columnAccount);
        newAccountLink.click();
        Thread.sleep(1500);
    }

    public By getTextBalance() {
        return textBalance;
    }

    public By getTextDetails() {
        return textDetails;
    }
}
