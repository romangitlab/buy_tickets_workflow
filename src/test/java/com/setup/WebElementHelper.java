package com.setup;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.setup.EnvProperties.DEFAULT_TIMEOUT;

public class WebElementHelper {

    private WebDriver driver;
    protected WebDriverWait wait;

    public WebElementHelper(WebDriver driver) {
        this.driver = DriverFactory.get().getDriver();
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public WebDriverWait getWebDriverWait() {
        return wait;
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isPageReady() {
        try {
            wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        } catch (WebDriverException e) {
            return false;
        }
        return true;
    }

    public boolean isElementVisible(WebElement webElement) {
        try {
            wait.until(driver -> ExpectedConditions.visibilityOf(webElement));
        } catch (ElementNotVisibleException e) {
            System.out.println(String.format("Couldn't display element \"%S\"!", webElement));
        }

        return true;
    }

    public void type(WebElement webElement, String text) throws InterruptedException {
        webElement.clear();
        webElement.sendKeys(text);
        sleep(1);
        webElement.sendKeys(Keys.CONTROL, Keys.ENTER);
    }

    public WebElementHelper clickAt(WebElement webElement) {
        isElementVisible(webElement);
        waitForElementToBeClickable(webElement);
        webElement.click();

        return this;
    }

    public Boolean hasValidationErrors(List<WebElement> errors) {
        return errors.size() > 0;
    }

    public Actions getActions(){
        return new Actions(driver);
    }

    public void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public Boolean waitForElementToBeClickable(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (ElementNotInteractableException e) {
            System.out.println(String.format("Couldn't click on element \"%S\"!", webElement));
        }

        return true;
    }
}
