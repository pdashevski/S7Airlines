package pages;

import elements.Input;
import elements.RadioButton;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class TripSearchPage extends BasePage {

    public static final String originRoute = "search-item departure search-item-with-react";
    public static final String destinationRoute = "search-item return search-item-with-react";

    public TripSearchPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("");
    }

    public void tripTypeRadioButtonSelect(String tripType) {
        new RadioButton(driver, tripType).select();
    }

    public void airportFrom(String origin) throws InterruptedException {
        new Input(driver, originRoute).write(origin);
        Thread.sleep(1000);
        new Input(driver, originRoute).selectFromDropDownAirport(origin);
    }

    public void airportTo(String destination) throws InterruptedException {
        new Input(driver, destinationRoute).write(destination);
        Thread.sleep(1000);
        new Input(driver, destinationRoute).selectFromDropDownAirport(destination);
    }
}
