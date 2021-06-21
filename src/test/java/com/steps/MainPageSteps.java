package com.steps;

import io.cucumber.java.en.Given;
import org.testng.Assert;
import com.pages.MainPage;

public class MainPageSteps {

    private final MainPage mainPage = new MainPage();

    @Given("I open cp.pt website")
    public void iOpenCpPtWebsite() {

        final String expectedUrl = "https://www.cp.pt/passageiros/en";
        mainPage.get();

        Assert.assertEquals(mainPage.getWebElementHelper().getCurrentUrl(), expectedUrl);
    }
}
