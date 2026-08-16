package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.cartPage;
import pages.productPage;
import utility.DriverFactory;


public class cartStep {
    cartPage cartPage = new cartPage(DriverFactory.getDriver());
    productPage productPage;

    @When("user click on Add to cart button")
    public void userClickOnAddToCartButton() {
        cartPage.clickOn_Add_To_cart_btn();
    }

    @Then("{string} this msg should come")
    public void thisAlertShouldCome(String popupMsg) throws InterruptedException {
        cartPage.verify_Products_AddedToCartMsg(popupMsg);
        Thread.sleep(3000);
    }

    @And("user click on view cart")
    public void userClickOnViewCart() {
        cartPage.clickOn_ViewCart();
    }

    @Then("verify product has stored in view cart")
    public void verifyProductHasStoredInViewCart() {
        cartPage.verifyProduct_In_ViewCart();
    }

    @When("user click on remove product from the cart")
    public void userClickOnRemoveProductFromTheCart() {
        cartPage.clickOnRemoveCart();
    }

    @Then("verify {string} message should come")
    public void verifyMessageShouldCome(String arg0) {
        cartPage.verify_ProductRemovedFromCart();
    }

    @When("Increase or Decrease product quantity")
    public void userIncreaseDecreaseProductQuantity() {
        cartPage.clickOn_IncreaseQuantity();
        cartPage.clickOn_DecreaseQuantity();
    }

    @Then("price should also change")
    public void priceShouldAlsoChange() {
        cartPage.clickOn_ViewCart();
        cartPage.validateChangesInPrices();
    }
}
