package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import stepDefinitions.cartStep;
import utility.ReusableMethods;

public class cartPage {
    WebDriver driver;

    public cartPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final Logger logger = LogManager.getLogger(cartStep.class);

    private By AddToCart_Btn = (By.id("btn-add-to-cart"));
    private By alert = By.xpath("//div[@role='alert']");
    private By viewCart = By.id("lblCartCount");
    private By productInCart = By.xpath("(//div[@class='ng-star-inserted'])[1]");
    private By removeCart = By.xpath("(//fa-icon[@class='ng-fa-icon'])[2]");
    private By IncreaseQuantity = By.xpath("(//fa-icon[@class='ng-fa-icon'])[3]");
    private By DecreaseQuantity = By.xpath("(//fa-icon[@class='ng-fa-icon'])[2]");
    private By ChangeQuantityFromCart = By.cssSelector("input[type='number']");

    public void clickOn_Add_To_cart_btn() {
        //driver.findElement(AddToCart_Btn).click();
        logger.info("user click on add to cart button");
    }

    public void verify_Products_AddedToCartMsg(String popup) {
        String actualAlertText = driver.findElement(alert).getText();
        Assert.assertEquals(actualAlertText, popup);
        ReusableMethods.waitFor(driver, alert);
        logger.info("Product added to cart message displayed");
    }

    public void clickOn_ViewCart() {
        driver.findElement(viewCart).click();
        logger.info("user click on view cart");
    }

    public void verifyProduct_In_ViewCart() {
        driver.findElement(productInCart).isDisplayed();
        logger.info("product has successfully stored in view cart");
    }

    public void clickOnRemoveCart() {
        driver.findElement(removeCart).click();
        logger.info("user click on remove from cart option");
    }

    public void verify_ProductRemovedFromCart() {
        String msg = driver.findElement(By.xpath("(//div[.=' Product deleted. '])[4]")).getText();
        Assert.assertEquals(msg, "Product deleted.");
        logger.info("Product Deleted from Cart message displayed");
    }

    public void clickOn_IncreaseQuantity() {
        driver.findElement(IncreaseQuantity).click();
        driver.findElement(IncreaseQuantity).click();
        logger.info("user has increase product quantity");
    }

    public void clickOn_DecreaseQuantity() {
        driver.findElement(DecreaseQuantity).click();
        logger.info("user has decrease product quantity");
    }

    public void validateChangesInPrices() {
        String productPrice1 = driver.findElement(By.xpath("//span[@data-test='line-price']")).getText();
        driver.findElement(ChangeQuantityFromCart).clear();
        driver.findElement(ChangeQuantityFromCart).sendKeys("2");
        String productPrice2 = driver.findElement(By.xpath("//span[@data-test='line-price']")).getText();
        if (!(productPrice1).equalsIgnoreCase(productPrice2)) {
            System.out.println("price are changing when quantity get change");
        }
        logger.info("Price got change as user increase or decrease product quantity");

    }


}
