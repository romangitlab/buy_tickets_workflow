package com.steps;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.pages.BuyTicketsPage;
import com.webComponents.DatePicker;

import java.util.ArrayList;
import java.util.List;

import static com.context.Context.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class BuyTicketsPageSteps {

    private final BuyTicketsPage buyTicketsPage = new BuyTicketsPage();
    DatePicker datePicker = new DatePicker();

    @And("I open Buy Tickets page")
    public void iOpenBuyTicketsPage() {

        final String expectedUrl = "https://www.cp.pt/passageiros/en/buy-tickets";

        buyTicketsPage.get();
        Assert.assertEquals(buyTicketsPage.getWebElementHelper().getCurrentUrl(), expectedUrl);
    }

    @And("I can see Online Tickets form")
    public void iCanSeeOnlineTicketsForm() {

        Assert.assertTrue(buyTicketsPage.getWebElementHelper().isElementVisible(buyTicketsPage.formSearch));
    }

    @And("I search for a train from {string} to {string}")
    public void iSearchForATrainFromTo(String fromCity, String toCity) throws InterruptedException {

        put("fromCity", fromCity);
        put("toCity", toCity);

        buyTicketsPage.getWebElementHelper().type(buyTicketsPage.from, fromCity);
        buyTicketsPage.getWebElementHelper().type(buyTicketsPage.to, toCity);

        Assert.assertFalse(buyTicketsPage.getWebElementHelper().hasValidationErrors(buyTicketsPage.hasErrors), "Please check inputs 'From' or 'To' there are validation errors. ");
    }

    @And("I choose to start the trip Lagos > Porto-Campanha in {int} days")
    public void iChooseToStartTheTripLagosPortoCampanhaInDays(int days) throws InterruptedException {
        List<WebElement> futureDates = new ArrayList<>();

        buyTicketsPage.getWebElementHelper().clickAt(buyTicketsPage.departDate);
        futureDates.addAll(buyTicketsPage.futureDates);
        futureDates.addAll(buyTicketsPage.futureDatesOutfocus);
        datePicker.selectFutureDate(futureDates, days);
        buyTicketsPage.getWebElementHelper().clickAt(buyTicketsPage.departDate);

        Integer selectedDate = datePicker.getSelectedDay(buyTicketsPage.selectedDate);

        put("start_selectedDate", selectedDate);
    }

    @And("I choose to return in {int} days from Porto-Campanha > Lagos after the start of the trip")
    public void iChooseToReturnInDaysFromPortoCampanhaLagosAfterTheStartOfTheTrip(int days) throws InterruptedException {
        List<WebElement> returnDates = new ArrayList<>();

        buyTicketsPage.getWebElementHelper().clickAt(buyTicketsPage.returnDate);
        returnDates.addAll(buyTicketsPage.futureDates);
        returnDates.addAll(buyTicketsPage.futureDatesOutfocus);
        datePicker.selectFutureDate(returnDates, days+3);
        buyTicketsPage.getWebElementHelper().clickAt(buyTicketsPage.returnDate);

        Integer selectedDate = datePicker.getSelectedDay(buyTicketsPage.selectedDate);

        put("end_selectedDate", selectedDate);
    }

    @And("I choose comfort class for passengers")
    public void iChooseComfortClassForPassengers() {

        buyTicketsPage.getWebElementHelper().clickAt(buyTicketsPage.comfortBtn);

        put("comfortClass", buyTicketsPage.comfortBtn.getText());
    }

    @And("I choose {int} passengers for the trip")
    public void iChoosePassengersForTheTrip(int passengers) {

        buyTicketsPage.getWebElementHelper().clickAt(buyTicketsPage.passengerBtn);
        buyTicketsPage.getWebElementHelper().clickAt(buyTicketsPage.passengerList.get(passengers-1));

        put("passengers", buyTicketsPage.passengerBtn.getText());
    }

    @And("I check that in Buy Tickets form's fields have remained data from last time")
    public void iCheckThatInBuyTicketsFormSFieldsHaveRemainedDataFromLastTime() throws InterruptedException {

        buyTicketsPage.getWebElementHelper().waitForElementToBeClickable(buyTicketsPage.from);
        assertThat(buyTicketsPage.from.getAttribute("value"), equalTo(get("fromCity", String.class)));
        assertThat(buyTicketsPage.to.getAttribute("value"), equalTo(get("toCity", String.class)));
        buyTicketsPage.getWebElementHelper().waitForElementToBeClickable(buyTicketsPage.departDate);
        assertThat(buyTicketsPage.departDate.getAttribute("value"), containsString(String.valueOf(get("start_selectedDate", Integer.class))));
        assertThat(buyTicketsPage.returnDate.getAttribute("value"), containsString(String.valueOf(get("end_selectedDate", Integer.class))));
        assertThat(buyTicketsPage.passengerBtn.getText(), equalTo(get("passengers", String.class)));
        assertThat(buyTicketsPage.comfortBtn.getText(), equalTo(get("comfortClass", String.class)));
    }

    @And("I click on Submit button")
    public void iClickOnSubmitButton() {
        buyTicketsPage.getWebElementHelper().clickAt(buyTicketsPage.submitBtn);
    }
}
