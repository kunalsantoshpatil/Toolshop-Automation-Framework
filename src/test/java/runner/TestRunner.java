package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = "src/test/resources/features/4cart.feature",
            glue={"stepDefinitions", "hooks"},
            plugin = {
                    "pretty",
                    "html:reports/cucumber-reports/cucumber.html",
                    "json:reports/cucumber-reports/cucumber.json",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
            },
            monochrome=true
    )
    public class TestRunner extends AbstractTestNGCucumberTests
    {
    }

