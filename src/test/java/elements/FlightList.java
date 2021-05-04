package elements;

import elements.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightList extends BaseElement {

    String segmentLocator = "//div[@data-qa='tripItem'][1]";
    String fareLocator = segmentLocator + "//div[@data-qa='tariffItem'][1]//button";

    public FlightList(WebDriver driver) {
        super(driver);
    }

    public void segment() {
        isElementPresent(By.xpath(segmentLocator));
        driver.findElement(By.xpath(segmentLocator)).click();
    }

    public void fare() {
        isElementPresent(By.xpath(fareLocator));
        driver.findElement(By.xpath(fareLocator)).click();
    }
}
