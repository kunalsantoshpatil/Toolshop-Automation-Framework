package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utility.FakerData;

public class registerPage {

    private WebDriver driver;
    // Locators
    private By registerLink = By.xpath("//a[.='Register your account']");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By dateOfBirth = By.id("dob");
    private By street = By.id("street");
    private By postalCode = By.id("postal_code");
    private By HouseNo=By.id("house_number");
    private By city = By.id("city");
    private By state = By.id("state");
    private By country = By.id("country");
    private By phone = By.id("phone");
    private By email = By.id("email");
    private By password = By.id("password");
    private By registerButton = By.xpath("//button[contains(.,'Register')]");
    private By existedEmail=By.xpath("(//div[.='A customer with this email address already exists.'])[3]");

    public registerPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnRegisterLink()
    {
        driver.findElement(registerLink).click();
    }

    public void enterFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value)
    {
        driver.findElement(lastName).sendKeys(value);
    }

    public void enterDateOfBirth(String value) {

        driver.findElement(dateOfBirth).sendKeys(value);
    }

    public void enterStreet(String value)
    {

        driver.findElement(street).sendKeys(value);
    }

    public void enterPostalCode(String value)
    {

        driver.findElement(postalCode).sendKeys(value);

    }
    public void enterHouseNo(String houseNo)
    {
        driver.findElement(HouseNo).sendKeys(houseNo);
    }

    public void enterCity(String value)
    {

        driver.findElement(city).sendKeys(value);
    }

    public void enterState(String value)
    {

        driver.findElement(state).sendKeys(value);
    }

    public void selectCountry(String value) {
        driver.findElement(country).sendKeys(value);
    }

    public void enterPhone(String value)
    {

        driver.findElement(phone).sendKeys(value);
    }

    public void enterEmail(String value)
    {

        driver.findElement(email).sendKeys(value);
    }

    public void enterPassword(String value)
    {

        driver.findElement(password).sendKeys(value);
    }

    public void clickRegister()
    {

        driver.findElement(registerButton).click();
    }

    public void CheckingAlreadyExistedEmail()
    {
        driver.findElement(existedEmail).isDisplayed();
    }
}
