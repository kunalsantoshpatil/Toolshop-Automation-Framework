package hooks;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.ConfigReader;
import utility.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class hooks {
    private static final Logger logger= LogManager.getLogger(hooks.class);

    @Before
    public void setUp(Scenario scenario) throws InterruptedException {
        DriverFactory.initializeDriver();
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
        Thread.sleep(1000);
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("==========================================================");
        logger.info("Starting Scenario: {}",scenario.getName());
        logger.info("==========================================================");
    }


    @After
    public void tearDown(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            logger.error("Scenario Failed: {}",scenario.getName());

            TakesScreenshot ts =
                    (TakesScreenshot) DriverFactory.getDriver();

            byte[] screenshot =
                    ts.getScreenshotAs(OutputType.BYTES);

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("HH-mm-ss_yyyy-MM-dd"));

            String screenshotName =
                    scenario.getName().replaceAll("[^a-zA-Z0-9-_]", "_")
                            + "_" + timestamp;

            // Attach screenshot to Cucumber + Extent
            scenario.attach(screenshot,"image/png",screenshotName);
            logger.info("Screenshot attached to Extent Report");
        }
        else
        {
            logger.info("Scenario PASSED: {}",scenario.getName());
        }
        logger.info("Finished Scenario: {}", scenario.getName());
        DriverFactory.quitDriver();
    }

    @AfterStep
    public void addWait() throws InterruptedException {
        Thread.sleep(2000);

    }


}
