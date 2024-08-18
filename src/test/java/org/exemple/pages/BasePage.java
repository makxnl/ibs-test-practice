package org.exemple.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.exemple.tests.BaseTest.driver;

public class BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement waitUntilElementToBeVisible(WebElement element) {
        return wait.until((ExpectedConditions.visibilityOf(element)));
    }

    public void fillInputField(WebElement field, String value) {
        waitUntilElementToBeVisible(field).click();
        field.sendKeys(value);
    }

}
