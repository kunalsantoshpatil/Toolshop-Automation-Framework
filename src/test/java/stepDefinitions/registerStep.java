package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.loginPage;
import pages.productPage;
import pages.registerPage;
import utility.DriverFactory;
import utility.FakerData;

public class registerStep {
    registerPage registerPage = new registerPage(DriverFactory.getDriver());
    loginPage loginPage=new loginPage(DriverFactory.getDriver());



    // Store generated credentials for later use
    static String email;
    static String password;

    @And("click on register link")
    public void clickOnRegisterLink() {
        registerPage.clickOnRegisterLink();
    }

    @When("I enter valid firstname and Lastname")
    public void iEnterValidFirstnameAndLastname() {

        registerPage.enterFirstName(FakerData.firstname());
        registerPage.enterLastName(FakerData.lastName());
    }

    @And("I enter the DOB")
    public void iEnterTheDOB() {

       registerPage.enterDateOfBirth(FakerData.dob());
    }

    @And("I enter valid address")
    public void iEnterValidAddress() {

        registerPage.enterStreet(FakerData.street());
        registerPage.enterPostalCode(FakerData.postalCode());
        registerPage.enterHouseNo(FakerData.houseNumber());
        registerPage.enterCity(FakerData.city());
        registerPage.enterState(FakerData.state());

        // Keep country fixed because Faker may generate
        // a country that does not exist in the dropdown
        registerPage.selectCountry(FakerData.country());

        //registerPage.enterPhone(FakerData.phone());
        registerPage.enterPhone(FakerData.phone());
    }

    @And("I enter valid email address")
    public void iEnterValidEmailAddress() {

        email = FakerData.emailAddress();
        registerPage.enterEmail(email);
    }

    @And("I enter valid password")
    public void iEnterValidPassword() {

        password = FakerData.password();
        registerPage.enterPassword(password);
    }

    @When("click on Register button")
    public void clickOnRegisterButton() throws InterruptedException {

        registerPage.clickRegister();
        Thread.sleep(4000);
    }

    @Then("my account should be created successfully")
    public void myAccountShouldBeCreatedSuccessfully() throws InterruptedException {
        Assert.assertEquals(DriverFactory.getDriver().getTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
        System.out.println("Registration successful");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        Thread.sleep(2000);
    }


    @And("I enter already existed email address")
    public void iEnterAlreadyExistedEmailAddress() {
        registerPage.enterEmail(email);//already registered email
        System.out.println("Already existed email is "+email);
    }

    @Then("my account should not created successfully")
    public void myAccountShouldNotCreatedSuccessfully() {
        registerPage.CheckingAlreadyExistedEmail();
        System.out.println(email+"Email already existed");
        System.out.println("2nd scenario Password: " + password);
       // throw new RuntimeException("Email already existed");
    }

    @Then("{string} message should see successfully")
    public void messageShouldSeeSuccessfully(String msg) throws InterruptedException {
       String error=DriverFactory.getDriver().findElement(By.xpath("//div[.=' Password is required ']")).getText();
        Assert.assertEquals(error,msg);
        Thread.sleep(2000);
    }

    @And("I enter Registered password")
    public void iEnterRegisteredPassword() {
        registerPage.enterPassword(password);
    }

}
