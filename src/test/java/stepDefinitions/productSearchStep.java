package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.loginPage;
import pages.productPage;
import utility.DriverFactory;
import utility.FakerData;

public class productSearchStep {
    productPage productPage=new productPage(DriverFactory.getDriver());

    @When("multiple products should get displayed")
    public void multipleProductsShouldGetDisplayed() {
        productPage.verify_MultipleProducts();
    }

    @And("user click on random product")
    public void userClickOnRandomProduct() {
        productPage.clickOn_randomProduct();
    }

    @Then("valid product description page should displayed")
    public void validProductDescriptionPageShouldDisplayed() {
        productPage.verify_Product_description_Page();
    }

    @And("user search valid product {string} in search box")
    public void userSearchValidProductInSearchBox(String product) {
        productPage.search_Product(product);
    }

    @And("click on search icon")
    public void clickOnSearchIcon()
    {

        productPage.clickOn_searchButton();
    }

    @Then("respective product description page should displayed")
    public void respectiveProductDescriptionPageShouldDisplayed() {
        productPage.verify_Product_description_Page();

    }

    @When("user search Invalid product in search box")
    public void userSearchInvalidProductInSearchBox() {
        productPage.search_InvalidProduct();
        productPage.clickOn_searchButton();
    }

    @Then("{string} message should displayed")
    public void messageShouldDisplayed(String msg)
    {

        productPage.validate_No_productsFound(msg);
    }

    @When("click on random checkbox add filter")
    public void clickOnRandomCheckboxAddFilter()
    {

        productPage.click_on_randomCheckBox();
    }

    @Then("validate respective products are showing or not")
    public void validateRespectiveProductsAreShowingOrNot()
    {

        productPage.validate_Respective_HammerProduct();
    }
}


