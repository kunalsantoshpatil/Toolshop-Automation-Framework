package utility;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class FakerData {


    static Faker faker = new Faker();

    public static String firstname() {

        return faker.name().firstName();
    }

    public static String lastName() {

        return faker.name().lastName();
    }

    public static String dob() {
        Date date = faker.date().birthday(18, 60);

        LocalDate birthDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return birthDate.toString();
    }

    public static String country() {
        Select select = new Select(DriverFactory.getDriver().findElement(By.id("country")));
        List<WebElement> countries = select.getOptions();

        int randomIndex = faker.number()
                .numberBetween(0, countries.size() - 1);

        select.selectByIndex(randomIndex);
        return countries.get(randomIndex).getText();
    }


    public static String postalCode() {

        return faker.address().zipCode();
    }

    public static String houseNumber() {

        return faker.address().buildingNumber();
    }

    public static String street() {
        return faker.address().streetName();
    }

    public static String city() {

        return faker.address().city();
    }

    public static String state() {
        return faker.address().state();
    }


    public static String phone() {
        int firstDigit = faker.number().numberBetween(6, 10);
        int remaining = faker.number().numberBetween(100000000, 999999999);

        return firstDigit + String.valueOf(remaining);
    }


    public static String emailAddress() {

        return faker.internet().emailAddress();
    }

    public static String password() {

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String number = "0123456789";
        String special = "@#";

        String all = upper + lower + number + special;

        StringBuilder password = new StringBuilder();

        password.append(upper.charAt(faker.random().nextInt(upper.length())));
        password.append(lower.charAt(faker.random().nextInt(lower.length())));
        password.append(number.charAt(faker.random().nextInt(number.length())));
        password.append(special.charAt(faker.random().nextInt(special.length())));

        for (int i = 0; i < 6; i++) {
            password.append(all.charAt(faker.random().nextInt(all.length())));
        }

        return password.toString();
    }

    public static String CreditCard_Number()
    {
        String cardNumber=faker.number().digits(16);
        return cardNumber.substring(0,4)+"-"+cardNumber.substring(4,8)+"-"+cardNumber.substring(8,12)+"-"+cardNumber.substring(12,16);
    }

    public static String Expiry_DateForCreditCard()
    {
        int month=faker.number().numberBetween(1,13);
        int year=faker.number().numberBetween(2027,2031);
        return String.format("%02d/%04d",month,year);
    }

    public static String CVV()
    {
        return faker.number().digits(3);
    }

    public static String CardHolderName()
    {
        return faker.name().fullName();
    }

    //BankTransfer
    public static String BankName()
    {
        String name= faker.company().name()
                .replaceAll("[^a-zA-Z ]","")
                .replaceAll("\\s+","").trim();
        return name+ " Bank";

    }
    public static String AccName()
    {
        return faker.name().fullName();

    }
    public static String AccNumber()
    {
        return faker.number().digits(12);

    }



}


