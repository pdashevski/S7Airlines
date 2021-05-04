package pages;

import models.Contacts;
import models.AdultPassenger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class PaymentPage extends BasePage {

    String firstNameLocator = "//input[@data-qa='firstName_pax']";
    String lastNameLocator = "//input[@data-qa='lastName_pax']";
    String birthday = "//input[@data-qa='birthday_pax']";
    String documentNumber = "//input[@data-qa='numberDocument_pax']";
    String email = "//input[@data-qa='email_contactPax']";
    String phone = "//input[@data-qa='phone_contactPax']";

    public static final String submitButton = "//div[@id='cart-fixed']//div[@class='js_shopping_cart_buttons']/button";
    public static final String payLaterTab = "//*[@class='js_sticky_button_trigger']//div[@data-tab-index='6']";
    public static final String female = "//div[@data-qa-error='errorGender_pax']";
    public static final String confirmCheckbox = "//input[@id='terms-check']";

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void createPassengerDetails(AdultPassenger adultPassenger) {
        driver.findElement(By.xpath(firstNameLocator)).sendKeys(adultPassenger.getFirstName());
        driver.findElement(By.xpath(lastNameLocator)).sendKeys(adultPassenger.getLastName());
        driver.findElement(By.xpath(birthday)).sendKeys(adultPassenger.getDateOfBirth());
        driver.findElement(By.xpath(documentNumber)).sendKeys(adultPassenger.getDocumentNumber());
    }

    public void createPassengerContacts(Contacts contacts) {
        driver.findElement(By.xpath(email)).sendKeys(contacts.getEmail());
        driver.findElement(By.xpath(phone)).sendKeys(contacts.getTelephoneNumber());
    }

    public void onHoldPayment() {
        driver.findElement(By.xpath(payLaterTab)).click();
    }

    public void sexSelect() {
        driver.findElement(By.xpath(female)).click();
    }

    public void submitPassenger() {
        isElementPresent(By.xpath(submitButton));
        isElementClickable(By.xpath(submitButton));
        driver.findElement(By.xpath(submitButton)).click();
        //driver.findElement(By.xpath(submitButton)).click();
    }

    public void confirmCheckboxSelect() {
        driver.findElement(By.xpath(confirmCheckbox)).click();
    }
}
