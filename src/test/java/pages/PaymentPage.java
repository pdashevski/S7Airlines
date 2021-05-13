package pages;

import io.qameta.allure.Step;
import models.Contacts;
import models.AdultPassenger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;

public class PaymentPage extends BasePage {

    String firstNameLocator = "//input[@data-qa='firstName_pax']";
    String lastNameLocator = "//input[@data-qa='lastName_pax']";
    String birthdayLocator = "//input[@data-qa='birthday_pax']";
    String documentNumberLocator = "//input[@data-qa='numberDocument_pax']";
    String email = "//input[@data-qa='email_contactPax']";
    String phone = "//input[@data-qa='phone_contactPax']";

    public static final String submitButton = "//div[@id='cart-fixed']//div[@class='js_shopping_cart_buttons']/button";
    public static final String payLaterTab = "//*[@class='js_sticky_button_trigger']//div[@data-tab-index='6']";
    public static final String female = "//div[@data-qa-error='errorGender_pax']";
    public static final String confirmCheckbox = "//input[@id='terms-check']";
    String passengerLocator = "//div[@id='persons-title']/h2";
    String loc1wait = "//form[@class='pax-list js-pax-list fadeout_enable']";

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Создание пассажира")
    public void createPassengerDetails(AdultPassenger adultPassenger) {
        checkFirstNameIsNotEmpty(adultPassenger);
        checkLastNameIsNotEmpty(adultPassenger);
        checkBirthdayIsNotEmpty(adultPassenger);
        //checkDocumentNumberIsNotEmpty(adultPassenger);
        //driver.findElement(By.xpath(firstNameLocator)).sendKeys(adultPassenger.getFirstName());
        //driver.findElement(By.xpath(lastNameLocator)).sendKeys(adultPassenger.getLastName());
        //driver.findElement(By.xpath(birthday)).sendKeys(adultPassenger.getDateOfBirth());
        try {
            driver.findElement(By.xpath(documentNumberLocator)).click();
            driver.findElement(By.xpath(documentNumberLocator)).sendKeys(adultPassenger.getDocumentNumber());
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
        } finally {
            driver.findElement(By.xpath(documentNumberLocator)).click();
            driver.findElement(By.xpath(documentNumberLocator)).sendKeys(adultPassenger.getDocumentNumber());
        }

    }

    public void fadeOutWait() {
        try {
            wait.until(ExpectedConditions.invisibilityOf((driver.findElement(By.xpath(loc1wait)))));
        } catch (Exception e) {
            Assert.fail("Не получилось ):");
        }
    }

    @Step("Получаем и прокидываем введенное firstName пассажира")
    public String firstNamePassengerField() {
        return driver.findElement(By.xpath(firstNameLocator)).getAttribute("value");
    }

    @Step("Получаем и прокидываем введенное firstName пассажира")
    public String lastNamePassengerField() {
        return driver.findElement(By.xpath(lastNameLocator)).getAttribute("value");
    }

    @Step("Получаем и прокидываем введенное birthday пассажира")
    public String dateOfirthPassengerField() {
        return driver.findElement(By.xpath(birthdayLocator)).getAttribute("value");
    }

    @Step("Получаем и прокидываем введенное documentNumber пассажира")
    public String documentNumberOfPassengerField() {
        return driver.findElement(By.xpath(documentNumberLocator)).getAttribute("value");
    }

    @Step("Проверяем корректность заполнения поля имени пассажира")
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

    @Step("Проверяем корректность заполнения поля фамилии пассажира")
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

    @Step("Проверяем корректность заполнения поля даты рождения")
    public void checkBirthdayIsNotEmpty(AdultPassenger adultPassenger) {
        boolean isNotEmpty = false;
        try {
            isElementPresent(By.xpath(birthdayLocator));
            while (!isNotEmpty) {
                driver.findElement(By.xpath(birthdayLocator)).clear();
                driver.findElement(By.xpath(birthdayLocator)).sendKeys(adultPassenger.getDateOfBirth());
                if (driver.findElement(By.xpath(birthdayLocator)).getAttribute("value").equals(adultPassenger.getDateOfBirth())) {
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
            isElementPresent(By.xpath(documentNumberLocator));
            while (!isNotEmpty) {
                driver.findElement(By.xpath(documentNumberLocator)).clear();
                driver.findElement(By.xpath(documentNumberLocator)).sendKeys(adultPassenger.getDocumentNumber());
                Thread.sleep(8000);
                if (driver.findElement(By.xpath(documentNumberLocator)).getAttribute("value").equals(adultPassenger.getDocumentNumber())) {
                    isNotEmpty = true;
                }
            }
        } catch (Exception e) {
            Assert.fail("DocumentNumber is not found...");
        }
    }

    public void formSubmitPassengerData() {
        driver.findElement(By.xpath(email)).click();
        fadeOutWait(); //?????????????????????? //TODO
    }

    @Step("Создание контактных данных пассажира")
    public void createPassengerContacts(Contacts contacts) {
        driver.findElement(By.xpath(email)).sendKeys(contacts.getEmail());
        driver.findElement(By.xpath(phone)).sendKeys(contacts.getTelephoneNumber());
    }

    @Step("Получаем и прокидываем введенный email пассажира")
    public String emailPassengerField() {
        return driver.findElement(By.xpath(email)).getAttribute("value");
    }

    @Step("Получаем и прокидываем введенный phone пассажира")
    public String phonePassengerField() {
        return driver.findElement(By.xpath(phone)).getAttribute("value");
    }

    @Step("Отложенная оплата бронирования")
    public void onHoldPayment() {
        isElementPresent(By.xpath(payLaterTab)); //если падает на этом моменте - можно смело удалить
        driver.findElement(By.xpath(payLaterTab)).click();
    }

    @Step("Выбораем пол пассажира")
    public void sexSelect() {
        try {
            driver.findElement(By.xpath(female)).click();
        } catch (NoSuchElementException exception) {
            Assert.fail("Не удалось выбрать пол пассажира. RadioButton не найден");
        }
    }

    @Step("Проверяем существование и выбор пола пассажира (radioButton)")
    public boolean sexRadioButtonPresent() {
        try {
            if (driver.findElement(By.xpath(female)).isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException exception) {
            Assert.fail("Пол пассажира не совпал с выбранным");
        }
        return false;
    }

    @Step("Подтверждение оплаты и данных пассажира. Проверка на существование и кликабельность кнопки submit")
    public void submitPassenger() {
        //TODO убрать слип
        /*try {
            Thread.sleep(7000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }*/
        isElementPresent(By.xpath(submitButton));
        isElementClickable(By.xpath(submitButton));
        driver.findElement(By.xpath(submitButton)).click();
    }

    @Step("Проверяем отображение чекбокса в корзине на странице оплаты и активируем его")
    public void confirmCheckboxSelect() {
        driver.findElement(By.xpath(confirmCheckbox)).click();
    }

    @Step("Проверка страницы BaggageAndSeats на переход с предыдущей страницы")
    public boolean isPageOpened() {
        return driver.findElement(By.xpath(passengerLocator)).isDisplayed();
    }
}
