package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.loginPage;
import utility.DriverFactory;

import java.sql.Driver;
import java.time.Duration;

public class loginStep {
    loginPage loginPage=new loginPage(DriverFactory.getDriver());
    static String email=registerStep.email;
    static String pass=registerStep.password;

    @When("user enter email {string} and password {string}")
    public void userEnterEmailAndPassword(String email2, String pass2) {
        loginPage.enterEmail(email2);
        loginPage.enterPassword(pass2);
    }

    @And("user click on login button")
    public void userClickOnLoginButton() throws InterruptedException {
        loginPage.clickOnLoginButton();
        Thread.sleep(3000);
    }

    @Then("user should see {string}")
    public void userShouldSee(String expectedResult) throws InterruptedException {
        loginPage.verifyExpectedResult(expectedResult);
    }

    @When("user should enter Registered email")
    public void userEnterEmailAndPassword() {
        loginPage.enterEmail(email);
    }

    @And("user should enter Registered password")
    public void userShouldEnterRegisteredPassword() {
        loginPage.enterPassword(pass);
    }

    @Then("user should login successfully")
    public void userShouldLoginSuccessfully() {
        //lp.verify_userHas_Successfully_login();
        System.out.println("log in successful");
        System.out.println("login email: "+email+"\n"+"login password: "+pass);
    }

    @Then("user should click on logout")
    public void userShouldClickOnLogout() throws InterruptedException {
//        lp.clickOnMenu();
//        lp.clickOnSignOut();
//        lp.verifyUser_isOnLoginPage();
        System.out.println("User has Logout successfully...!");
    }

}

