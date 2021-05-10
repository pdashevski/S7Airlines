package pages;

import elements.Button;
import elements.Calendar;
import elements.Input;
import elements.RadioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.base.BasePage;
import utils.PropertyReader;

public class TripSearchPage extends BasePage {

    public static final String originRoute = "search-item departure";
    public static final String destinationRoute = "search-item return";
    public static final String feedbackLocator = "//div[@id='_hj_feedback_container']//button";
    protected WebDriverWait wait;

    public TripSearchPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 25);
    }

    public void open() {
        driver.get(System.getenv().getOrDefault(propertyPath, PropertyReader.getProperty("URL")));
    }

    public void tripTypeRadioButtonSelect(String tripType) {
        new RadioButton(driver, tripType).select();
    }

    public void isFeedbackDisplayed() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(feedbackLocator))));
        } catch (NoSuchElementException |TimeoutException exception) {
            Assert.fail("FeedBack Element cannot be found");
        }
    }

    public void airportFrom(String origin) throws InterruptedException {
        new Input(driver, originRoute).selectFromDropDownAirport(origin);
    }

    public void airportTo(String destination) throws InterruptedException {
        new Input(driver, destinationRoute).selectFromDropDownAirport(destination);
    }

    public void calendarClickButton(String calendarButtonName) {
        new Button(driver, calendarButtonName).clickCalendarButton();
    }

    public void calendarSelectMonthAndDay(String month, String day) {
        new Calendar(driver, month, day).selectMonthAndDayInCalendar();
    }

    public void searchSubmit() {
        new Button(driver).clickSubmitButton();
    }
}
