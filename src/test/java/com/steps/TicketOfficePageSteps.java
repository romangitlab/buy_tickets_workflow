package com.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import com.pages.TicketOfficePage;
import static com.context.Context.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertTrue;

public class TicketOfficePageSteps  {

    private final TicketOfficePage ticketOfficePage = new TicketOfficePage();

    @And("I can see Online Tickets Office service")
    public void iCanSeeOnlineTicketsOfficeService() {
        assertThat(ticketOfficePage.searchTitle.getText(), equalTo("Online Ticket Office"));
        assertThat(ticketOfficePage.reserveDiv.getText(), containsString(get("passengers", String.class).replace("\n ", "").replace("rs", "r")));
    }

    @And("I choose the {int} service in the outward list")
    public void iChooseTheServiceInTheOutwardList(int numberService) {
        ticketOfficePage.outwardService.get(numberService-1).click();
    }

    @And("I choose the {int} service in the inward list")
    public void iChooseTheServiceInTheInwardList(int numberService) {
        ticketOfficePage.inwardService.get(numberService-1).click();
    }

    @And("I click on the checkbox that I declare that I have read and accepted")
    public void iClickOnTheCheckboxThatIDeclareThatIHaveReadAndAccepted() {
        ticketOfficePage.getWebElementHelper().clickAt(ticketOfficePage.travelTermsBox);
    }

    @And("I click on Continue button")
    public void iClickOnContinueButton() {
        ticketOfficePage.getWebElementHelper().clickAt(ticketOfficePage.buttonNext);
    }

    @And("I see authorization form to continue with the purchase")
    public void iSeeAuthorizationFormToContinueWithThePurchase() {
        assertTrue(ticketOfficePage.getWebElementHelper().isElementVisible(ticketOfficePage.authForm));
    }

    @When("I click on Cancel button")
    public void iClickOnCancelButton() {
        ticketOfficePage.getWebElementHelper().clickAt(ticketOfficePage.exitButton);
    }
}
