package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class BuyTicketsPage extends BasePage<BuyTicketsPage> {

    @FindBy(how = How.XPATH, using = "//*[@id=\"datepicker-first\"]")
    public WebElement departDate;

    @FindBy(how = How.XPATH, using = "//*[@id=\"datepicker-second\"]")
    public WebElement returnDate;

    @FindBy(how = How.CSS, using = ".form")
    public WebElement formSearch;

    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement searchTitle;

    @FindBy(how = How.CSS, using = ".input-group.has-error")
    public List<WebElement> hasErrors;

    @FindBy(how = How.NAME, using = "textBoxPartida")
    public WebElement from;

    @FindBy(how = How.NAME, using = "textBoxPartida>ul>li.active>a>strong")
    public WebElement fromActive;

    @FindBy(how = How.NAME, using = "textBoxChegada")
    public WebElement to;

    @FindBy(how = How.CSS, using = "div.picker--focused .picker__day--infocus:not(.picker__day--disabled):not(.picker__day--selected)")
    public List<WebElement> futureDates;

    @FindBy(how = How.CSS, using = "div.picker--focused .picker__day--today")
    public WebElement todayDate;

    @FindBy(how = How.CSS, using = "div.picker--focused .picker__day--selected")
    public WebElement selectedDate;

    @FindBy(how = How.CSS, using = "ul.dropdown-menu>li.active")
    public WebElement selectDropList;

    @FindBy(how = How.ID, using = "option1Label")
    public WebElement comfortBtn;

    @FindBy(how = How.CSS, using = "ul.selectpicker>li>a")
    public List<WebElement> passengerList;

    @FindBy(how = How.CSS, using = ".bootstrap-select")
    public WebElement passengerBtn;

    @FindBy(how = How.CSS, using = "input[type='submit']")
    public WebElement submitBtn;

    public BuyTicketsPage() {
        super("/passageiros/en/buy-tickets");
    }
}
