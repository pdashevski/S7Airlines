package pages;

import elements.FlightList;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class FlightSearchPage extends BasePage {

    public static final String submitButton = "//div[@data-qa='shopCart_block']//span[contains(text(),'Продолжить')]/ancestor::button";
    public static final String pageMainLocator = "//div[@data-qa='tripToBlock']//h3";

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    public void selectFare() {
        FlightList list = new FlightList(driver);
        list.segment();
        list.fare();
    }

    public void flightSubmit() {
        isElementPresent(By.xpath(submitButton));
        isElementClickable(By.xpath(submitButton));
        try {
            driver.findElement(By.xpath(submitButton)).click();
        } catch (ElementClickInterceptedException exception) {
            System.out.println("Element" +submitButton + " cannot be clickable");
        }
    }

    public boolean isPageOpened() {
        return driver.findElement(By.xpath(pageMainLocator)).isDisplayed();
    }
}
