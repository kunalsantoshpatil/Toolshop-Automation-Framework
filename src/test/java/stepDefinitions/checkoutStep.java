package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.cartPage;
import pages.checkoutPage;
import pages.productPage;
import utility.DriverFactory;

public class checkoutStep {
    checkoutPage checkoutPage = new checkoutPage(DriverFactory.getDriver());
    cartPage cartPage;
    productPage productPage;

    @Given("user has searched the product")
    public void userHasAddedProductToTheCart() {
        productPage = new productPage(DriverFactory.getDriver());
        productPage.verify_MultipleProducts();
        productPage.clickOn_randomProduct();
    }

    @And("user has added product to the cart")
    public void userIsOnViewCartSection() {
        cartPage = new cartPage(DriverFactory.getDriver());
        cartPage.clickOn_Add_To_cart_btn();
        cartPage.clickOn_ViewCart();
    }

    @And("user is on view cart section")
    public void presentOnViewCartSection() {
        cartPage.verifyProduct_In_ViewCart();
    }

    @When("user click on proceed to checkout")
    public void userClickOnProceedToCheckout() {
        checkoutPage.clickOn_ProceedToCheckout();
    }

    @And("click on first Continue as guest")
    public void clickOnFirstContinueAsGuest() {
        checkoutPage.clickOn_continueAsGuest1();
    }

    @And("enter guest emailID,firstname,lastname")
    public void enterGuestEmailIDFirstnameLastname() {
        checkoutPage.enterGuest_Email();
        checkoutPage.enterGuest_FirstName();
        checkoutPage.enterGuest_LastName();
    }

    @And("click on second Continue as guest")
    public void clickOnSecondContinueAsGuest() {
        checkoutPage.clickOn_continueAsGuest2();
    }

    @And("user click on second proceed to checkout")
    public void userClickOnSecondProceedToCheckout() {
        checkoutPage.clickOn_ProceedToCheckout2();
    }

    @And("enter billing address")
    public void enterBillingAddress() throws InterruptedException {
        checkoutPage.enterBillingAddress();
        Thread.sleep(1000);
    }

    @And("user click on third proceed to checkout")
    public void userClickOnThirdProceedToCheckout() {
        checkoutPage.clickOn_ProceedToCheckout3();
    }

    @And("click on confirm")
    public void clickOnConfirm() {
        checkoutPage.clickOn_Confirm();
    }

    @Then("{string} message should come")
    public void messageShouldCome(String msg) {
        checkoutPage.verify_paymentSuccessMsg(msg);
    }

    @When("user choose payment method {string}")
    public void choosePaymentMethod(String methodName) {
        checkoutPage.choosePaymentMethod(methodName);
    }

    @And("enter credit card number")
    public void enterCreditCardNumber() {
        checkoutPage.enterCreditCardNo();
    }

    @And("enter expiration date")
    public void enterExpirationDate() {
       checkoutPage.enterExpiryDate();
    }

    @And("enter CVV")
    public void enterCVV() {
        checkoutPage.enterCVV();
    }

    @And("enter card holder name")
    public void enterCardHolderName() {
       checkoutPage.enterCardHolderName();
    }
//Bank Transfer
    @And("enter Bank Name")
    public void enterBankName() {
        checkoutPage.enterBankName();
    }

    @And("enter Account Name")
    public void enterAccountName() {
        checkoutPage.enterAccName();
    }

    @And("enter Account Number")
    public void enterAccountNumber() {
        checkoutPage.enterAccNumber();
    }
//Buy now Pay later
    @And("select any monthly installment option")
    public void selectAnyMonthlyInstallmentOption() {
        checkoutPage.selectMonthlyInstallmentDropdown();
    }
}
