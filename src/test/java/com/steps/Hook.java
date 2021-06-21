package com.steps;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import com.setup.DriverFactory;


public class Hook {

    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Starting the browser");
        DriverFactory.get().startBrowser();
        this.driver = DriverFactory.get().getDriver();
    }


    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Closing the browser");
    }

    @BeforeStep
    public void BeforeEveryStep(Scenario scenario) {
        System.out.println("Stated step - " + scenario.getName());
    }

    @AfterStep
    public void AfterEveryStep(Scenario scenario) {
        System.out.println("Ended step - " + scenario.getName());
    }

}
