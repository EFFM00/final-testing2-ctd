package com.elenaffm.finaltesting.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoggedPage {

    WebDriver driver;
    WebDriverWait wait;
    By newAccountLink = By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[1]/a");
    By accountTypeInput = By.xpath("//*[@id=\"type\"]");
    By openNewAccountBtn = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input");
    By msgSuccess = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]");

    public LoggedPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToNewAccountPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement newAccountLink = driver.findElement(this.newAccountLink);
        newAccountLink.click();
    }

    public void selectAccountType() {
        WebElement listOpt = driver.findElement(accountTypeInput);
        List<WebElement> options = listOpt.findElements(By.tagName("option"));

        for(int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals("SAVINGS")) {
                options.get(i).click();
            }
        }
    }


    public String checkMsg() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(msgSuccess));
        WebElement msgResult = driver.findElement(msgSuccess);
        String text = msgResult.getText();

        return text;
    }

    public void sendFormNewAccount() {

        WebElement btn = driver.findElement(openNewAccountBtn);

            btn.click();
        }
    }

}
