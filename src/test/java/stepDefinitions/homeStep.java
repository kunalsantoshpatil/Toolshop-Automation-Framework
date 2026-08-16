package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.productPage;
import utility.DriverFactory;

public class homeStep {
    HomePage homePage;

    @Given("user is on Home Page")
    public void userIsOnHomePage() {
        homePage = new HomePage(DriverFactory.getDriver());
        homePage.Verify_HomePage();
    }
    @And("user click on signIn button")
    public void userClickOnSignInButton() {
        homePage.clickOn_SignIn_from_Menu();
    }
}
