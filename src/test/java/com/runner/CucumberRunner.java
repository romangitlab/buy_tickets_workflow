package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {
                "pretty", "html:target/cucumber-report/single",
                "json:target/reports/cucumber.json",
        },
        glue = {"com.steps"},
        publish = true

)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
