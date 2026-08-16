package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver driver;

    public static void initializeDriver() throws InterruptedException {
        ChromeOptions option=new ChromeOptions();
        option.addArguments("--disable-popup-blocking");
        option.addArguments("disable-notification");
        String browser = ConfigReader.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(option);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Unsupported Browser:" + browser);
        }
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if(driver==null)
        {
            throw new RuntimeException("Browser is not initialized");
        }
        return driver;

    }

    public static void quitDriver() {
        if(driver!=null)
        {
            driver.quit();
        }
    }
}
