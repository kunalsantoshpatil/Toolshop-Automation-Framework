package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utility.FakerData;

public class checkoutPage {
    WebDriver driver;

    public checkoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By proceedToCheckout1 = By.xpath("//button[.='Proceed to checkout']");
    private By proceedToCheckout2 = By.xpath("//button[@data-test='proceed-2-guest']");
    private By proceedToCheckout3 = By.xpath("//button[@data-test='proceed-3']");
    private By continueAsGuest1 = By.linkText("Continue as Guest");
    private By guestEmailId = By.id("guest-email");
    private By guestFirstName = By.id("guest-first-name");
    private By guestLastName = By.id("guest-last-name");
    private By continueAsGuest2 = By.xpath("//input[@value='Continue as Guest']");
    private By postalCode = By.id("postal_code");
    private By houseNO = By.id("house_number");
    private By street = By.id("street");
    private By city = By.id("city");
    private By state = By.id("state");
    private By confirm = By.xpath("//button[.=' Confirm ']");
    private By paymentSuccessMsg = By.xpath("//div[@data-test='payment-success-message']");

    //creditCard
    private By creditCardTF = By.id("credit_card_number");
    private By expiration_dateTF = By.id("expiration_date");
    private By cvvTF = By.id("cvv");
    private By card_holder_nameTF = By.id("card_holder_name");

    //Bank Transfer
    private By bankNameTF = By.id("bank_name");
    private By accName = By.id("account_name");
    private By accNumber = By.id("account_number");

    public void clickOn_ProceedToCheckout() {
        driver.findElement(proceedToCheckout1).click();
    }

    public void clickOn_continueAsGuest1() {
        driver.findElement(continueAsGuest1).click();
    }

    public void enterGuest_Email() {
        driver.findElement(guestEmailId).sendKeys(FakerData.emailAddress());
    }

    public void enterGuest_FirstName() {
        driver.findElement(guestFirstName).sendKeys(FakerData.firstname());
    }

    public void enterGuest_LastName() {
        driver.findElement(guestLastName).sendKeys(FakerData.lastName());
    }

    public void clickOn_continueAsGuest2() {
        driver.findElement(continueAsGuest2).click();
    }

    public void clickOn_ProceedToCheckout2() {
        driver.findElement(proceedToCheckout2).click();
    }

    public void clickOn_ProceedToCheckout3() {
        driver.findElement(proceedToCheckout3).click();
    }

    public void enterBillingAddress() {
        Select select = new Select(driver.findElement(By.id("country")));
        select.selectByVisibleText("India");
        driver.findElement(postalCode).sendKeys(FakerData.postalCode());
        driver.findElement(houseNO).sendKeys(FakerData.houseNumber());
        driver.findElement(street).sendKeys(FakerData.street());
        driver.findElement(city).sendKeys(FakerData.city());
        driver.findElement(state).sendKeys(FakerData.state());
    }

    public void choosePaymentMethod(String methodName) {
        Select select = new Select(driver.findElement(By.id("payment-method")));
        switch (methodName) {
            case "Cash on Delivery":
                select.selectByVisibleText("Cash on Delivery");
                break;
            case "Credit Card":
                select.selectByVisibleText("Credit Card");
                break;
            case "Bank Transfer":
                select.selectByVisibleText("Bank Transfer");
                break;
            case "Buy Now Pay Later":
                select.selectByVisibleText("Buy Now Pay Later");
                break;
            default:
                System.out.println("Invalid Payment Method");
        }

    }

    public void clickOn_Confirm() {
        driver.findElement(confirm).click();
    }

    public void verify_paymentSuccessMsg(String expectedText) {
        String actualText = driver.findElement(paymentSuccessMsg).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    public void enterCreditCardNo() {
        driver.findElement(creditCardTF).sendKeys(FakerData.CreditCard_Number());

    }

    public void enterExpiryDate() {
        driver.findElement(expiration_dateTF).sendKeys(FakerData.Expiry_DateForCreditCard());

    }

    public void enterCVV() {
        driver.findElement(cvvTF).sendKeys(FakerData.CVV());

    }

    public void enterCardHolderName() {
        driver.findElement(card_holder_nameTF).sendKeys(FakerData.CardHolderName());

    }

    public void enterBankName() {
        driver.findElement(bankNameTF).sendKeys(FakerData.BankName());
    }

    public void enterAccName() {
        driver.findElement(accName).sendKeys(FakerData.AccName());
    }

    public void enterAccNumber() {
        driver.findElement(accNumber).sendKeys(FakerData.AccNumber());
    }

    public void selectMonthlyInstallmentDropdown()
    {
        Select select=new Select(driver.findElement(By.id("monthly_installments")));
        select.selectByVisibleText("3 Monthly Installments");
    }


}
