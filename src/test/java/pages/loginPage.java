package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.DriverFactory;
import utility.ReusableMethods;

import java.time.Duration;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By emailtf = (By.id("email"));
    private By passtf = (By.id("password"));
    private By loginBtn = (By.xpath("//input[@data-test='login-submit']"));
    private By UsernameMenu = (By.xpath("//button[@id='menu']"));
    private By signOut =(By.xpath("//a[.='Sign out']"));

    public void enterEmail(String email) {
        driver.findElement(emailtf).sendKeys(email);
    }

    public void enterPassword(String pass)
    {

        driver.findElement(passtf).sendKeys(pass);
    }

    public void clickOnLoginButton()
    {
        driver.findElement(loginBtn).click();
    }

    public void verifyLoginPage() {
        Assert.assertEquals(driver.getTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
    }

    public void verify_userHas_Successfully_login()
    {
        Assert.assertEquals(driver.getTitle(),"Overview - Practice Software Testing - Toolshop - v5.0");
    }

    public void clickOnMenu() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(UsernameMenu)).click();
        Thread.sleep(3000);

    }

    public void clickOnSignOut() throws InterruptedException {
        driver.findElement(signOut).click();
        Thread.sleep(2000);
    }

    public void verifyUser_isOnLoginPage() throws InterruptedException {
        String expectedTitle="Login - Practice Software Testing - Toolshop - v5.0";
        String actualTitle=driver.getTitle();
        if(expectedTitle.equalsIgnoreCase(actualTitle))
        {
            System.out.println("User has successfully logout");
        }
        Thread.sleep(2000);
    }


    public void verifyExpectedResult(String expectedResult) {
        switch (expectedResult) {

            case "Invalid email or password":

                Assert.assertTrue(
                        driver.findElement(By.xpath("//div[text()='Invalid email or password']")
                        ).isDisplayed());
                System.out.println("Invalid email or password");

                break;


            case "Email format is invalid":

                Assert.assertTrue(
                        driver.findElement(By.xpath("//div[text()='Email format is invalid']")
                        ).isDisplayed());

                System.out.println("Email format is invalid");

                break;


            case "Email is required":

                Assert.assertTrue(
                        driver.findElement(By.xpath("(//div[.='Email is required'])[2]")
                        ).isDisplayed(), "Email required message was not displayed");

                System.out.println("Email required message displayed");

                break;


            case "Password is required":

                Assert.assertTrue(
                        driver.findElement(By.xpath("(//div[.='Password is required'])[2]")).isDisplayed(), "Password required message was not displayed");

                System.out.println("Password required message displayed");

                break;


            default:

                throw new IllegalArgumentException(
                        "Unknown expected result: " + expectedResult
                );
        }
    }


}
