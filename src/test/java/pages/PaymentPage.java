package pages;

import models.Contacts;
import models.AdultPassenger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        checkFirstNameIsNotEmpty(adultPassenger);
        checkLastNameIsNotEmpty(adultPassenger);
        checkBirthdayIsNotEmpty(adultPassenger);
        //checkDocumentNumberIsNotEmpty(adultPassenger);
        //driver.findElement(By.xpath(firstNameLocator)).sendKeys(adultPassenger.getFirstName());
        //driver.findElement(By.xpath(lastNameLocator)).sendKeys(adultPassenger.getLastName());
        //driver.findElement(By.xpath(birthday)).sendKeys(adultPassenger.getDateOfBirth());
        driver.findElement(By.xpath(documentNumber)).sendKeys(adultPassenger.getDocumentNumber());
    }

    public void checkFirstNameIsNotEmpty(AdultPassenger adultPassenger) {
        boolean isNotEmpty = false;
        try {
            isElementPresent(By.xpath(firstNameLocator));
            while (!isNotEmpty) {
                driver.findElement(By.xpath(firstNameLocator)).clear();
                driver.findElement(By.xpath(firstNameLocator)).sendKeys(adultPassenger.getFirstName());
                if (driver.findElement(By.xpath(firstNameLocator)).getAttribute("value").equals(adultPassenger.getFirstName())) {
                    isNotEmpty = true;
                }
            }
        } catch (Exception e) {
            Assert.fail("FirstName is not found...");
        }
    }

    public void checkLastNameIsNotEmpty(AdultPassenger adultPassenger) {
        boolean isNotEmpty = false;
        try {
            isElementPresent(By.xpath(lastNameLocator));
            while (!isNotEmpty) {
                driver.findElement(By.xpath(lastNameLocator)).clear();
                driver.findElement(By.xpath(lastNameLocator)).sendKeys(adultPassenger.getLastName());
                if (driver.findElement(By.xpath(lastNameLocator)).getAttribute("value").equals(adultPassenger.getLastName())) {
                    isNotEmpty = true;
                }
            }
        } catch (Exception e) {
            Assert.fail("LastName is not found...");
        }
    }

    public void checkBirthdayIsNotEmpty(AdultPassenger adultPassenger) {
        boolean isNotEmpty = false;
        try {
            isElementPresent(By.xpath(birthday));
            while (!isNotEmpty) {
                driver.findElement(By.xpath(birthday)).clear();
                driver.findElement(By.xpath(birthday)).sendKeys(adultPassenger.getDateOfBirth());
                if (driver.findElement(By.xpath(birthday)).getAttribute("value").equals(adultPassenger.getDateOfBirth())) {
                    isNotEmpty = true;
                }
            }
        } catch (Exception e) {
            Assert.fail("Birthday is not found...");
        }
    }

    public void checkDocumentNumberIsNotEmpty(AdultPassenger adultPassenger) {
        boolean isNotEmpty = false;
        try {
            isElementPresent(By.xpath(documentNumber));
            while (!isNotEmpty) {
                driver.findElement(By.xpath(documentNumber)).clear();
                driver.findElement(By.xpath(documentNumber)).sendKeys(adultPassenger.getDocumentNumber());
                Thread.sleep(10000);
                if (driver.findElement(By.xpath(documentNumber)).getAttribute("value").equals(adultPassenger.getDocumentNumber())) {
                    isNotEmpty = true;
                }
            }
        } catch (Exception e) {
            Assert.fail("DocumentNumber is not found...");
        }
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
