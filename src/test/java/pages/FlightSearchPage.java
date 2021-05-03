package pages;

import elements.FlightList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class FlightSearchPage extends BasePage {

    public static final String submitButton = "//span[contains(text(),'Продолжить')]/ancestor::button";

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    public void selectFare() {
        FlightList list = new FlightList(driver);
        list.segment();
        list.fare();
    }

    public void submit() {
        driver.findElement(By.xpath(submitButton)).click();

    }
}
