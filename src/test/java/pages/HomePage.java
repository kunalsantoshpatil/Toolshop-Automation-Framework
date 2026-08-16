package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.ReusableMethods;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private By signIn = (By.xpath("//a[.='Sign in']"));

    public void Verify_HomePage()
    {
        Assert.assertEquals(driver.getTitle(),"Practice Software Testing - Toolshop - v5.0");
    }


    public void clickOn_SignIn_from_Menu()
    {
        driver.findElement(signIn).click();
        ReusableMethods.waitFor(driver,signIn);
    }
}
