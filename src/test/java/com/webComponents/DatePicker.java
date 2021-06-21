package com.webComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.setup.DriverFactory;
import com.helpers.WebElementHelper;

import java.util.List;

public class DatePicker {

    private WebDriver driver = DriverFactory.get().getDriver();
    protected WebElementHelper elementHelper;

    public DatePicker(){
        this.driver = DriverFactory.get().getDriver();
        this.elementHelper = new WebElementHelper(this.driver);
    }

    public DatePicker selectFutureDate(List<WebElement> futureDates, Integer days){
        futureDates
                .stream()
                .filter(WebElement -> WebElement.isEnabled() && WebElement.isDisplayed())
                .skip(days)
                .findFirst()
                .ifPresent(WebElement::click);

        return this;
    }

    public Integer getCurrentDay(WebElement currentDay) throws InterruptedException {
        elementHelper.isElementVisible(currentDay);
        if(currentDay.getText().equals("")){
            elementHelper.sleep(1);
            return Integer.valueOf(currentDay.getText());
        }
        return Integer.valueOf(currentDay.getText());
    }

    public Integer getSelectedDay(WebElement selectedDay) throws InterruptedException {
        elementHelper.isElementVisible(selectedDay);
        if(selectedDay.getText().equals("")){
            elementHelper.sleep(1);
            return Integer.valueOf(selectedDay.getText());
        }
        return Integer.valueOf(selectedDay.getText());
    }

}
