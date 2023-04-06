package com.elenaffm.finaltesting.Pages;

import com.elenaffm.finaltesting.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OpenAccountPage extends BasePage {

    WebDriverWait wait;
    By newAccountLink = By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[1]/a");
    By accountTypeInput = By.xpath("//*[@id=\"type\"]");
    By openNewAccountBtn = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input");
    By msgSuccess = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]");


    public OpenAccountPage(WebDriver driver) {
        super(driver);
    }

    public void goToNewAccountPage() throws InterruptedException {
        WebElement newAccountLink = super.getDriver().findElement(this.newAccountLink);
        newAccountLink.click();
        Thread.sleep(1500);
    }

    public void selectAccountType() throws InterruptedException {
        WebElement listOpt = super.getDriver().findElement(accountTypeInput);
        List<WebElement> options = listOpt.findElements(By.tagName("option"));

        for(int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals("SAVINGS")) {
                options.get(i).click();
            }
        }

        Thread.sleep(1000);

    }


    public String checkMsg() {
        wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(msgSuccess));
        WebElement msgResult = super.getDriver().findElement(msgSuccess);
        String text = msgResult.getText();

        return text;
    }

    public void sendFormNewAccount() {
        WebElement btn = super.getDriver().findElement(this.openNewAccountBtn);
        btn.click();
    }
}