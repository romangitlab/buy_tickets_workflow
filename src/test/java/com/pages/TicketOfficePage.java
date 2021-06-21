package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class TicketOfficePage extends BasePage<TicketOfficePage> {

    @FindBy(how = How.CSS, using = "div>h1")
    public WebElement searchTitle;

    @FindBy(how = How.CSS, using = "span.reserveDiv")
    public WebElement reserveDiv;

    @FindBy(how = How.CSS, using = "td[headers='rad'] input[type='radio'][name='GO']")
    public List<WebElement> outwardService;

    @FindBy(how = How.CSS, using = "td[headers='rad'] input[type='radio'][name='BACK']")
    public List<WebElement> inwardService;

    @FindBy(how = How.CSS, using = "label[for='travelTerms'] i")
    public WebElement travelTermsBox;

    @FindBy(how = How.ID, using = "buttonNext")
    public WebElement buttonNext;

    @FindBy(how = How.ID, using = "form")
    public WebElement authForm;

    @FindBy(how = How.ID, using = "exitButton")
    public WebElement exitButton;

    public TicketOfficePage() {
        super("");
    }
}
