package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class productPage {
    WebDriver driver;

    public productPage(WebDriver driver) {
        this.driver = driver;
    }

    private By Home = (By.xpath("//a[.='Home']"));
    private By multipleProducts = (By.xpath("(//div[@class='container'])[4]"));
    private By randomProducts = (By.xpath("(//div[@class='card-body'])[1]"));
    private By prod_description = (By.xpath("//p[@id='description']"));
    private By search_Box = (By.id("search-query"));
    private By searchBtn = (By.xpath("//button[.='Search ']"));
    private By text = (By.xpath("(//div[.='There are no products found.'])[2]"));
    private By checkBox = (By.xpath("(//input[@name='category_id'])[2]"));
    private By HammerProd = (By.xpath("(//h5[contains(text(),' Hammer ')])[2]"));


    public void clickOn_Home() throws InterruptedException {
        //driver.get("https://practicesoftwaretesting.com/");
        driver.findElement(Home).click();
        Thread.sleep(2000);
    }

    public void verify_MultipleProducts() {
        driver.findElement(multipleProducts).isDisplayed();
    }

    public void clickOn_randomProduct() {
        driver.findElement(randomProducts).click();
    }

    public void verify_Product_description_Page() {
        driver.findElement(prod_description).isDisplayed();
    }

    public void search_Product(String product) {
        driver.findElement(search_Box).sendKeys(product);
    }

    public void clickOn_searchButton() {
        driver.findElement(searchBtn).click();
    }

    public void search_InvalidProduct() {
        driver.findElement(search_Box).sendKeys("fgdfgfg");
    }

    public void validate_No_productsFound(String msg) {
        Assert.assertEquals(driver.findElement(text).getText(), msg);
    }

    public void click_on_randomCheckBox() {
        driver.findElement(checkBox).click();
    }

    public void validate_Respective_HammerProduct() {
        String text = driver.findElement(HammerProd).getText();
        if (text.contains("Hammer")) {
            System.out.println("Filter option has showing correct result");
        }
    }


}
