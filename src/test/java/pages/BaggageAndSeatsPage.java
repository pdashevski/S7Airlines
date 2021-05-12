package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class BaggageAndSeatsPage extends BasePage {

    public static final String submitButton = "//span[contains(text(),'Далее')]/ancestor::button";
    public static final String pageMainLocator = "//h2[contains(text(),'Выберите услуги для комфортной поездки')]";

    public BaggageAndSeatsPage(WebDriver driver) {
        super(driver);
    }

    public void autoAndHotelsSubmit() {
        isElementPresent(By.xpath(submitButton));
        driver.findElement(By.xpath(submitButton)).click();
    }

    @Step("Проверка страницы BaggageAndSeats на переход с предыдущей страницы")
    public boolean isPageOpened() {
        return driver.findElement(By.xpath(pageMainLocator)).isDisplayed();
    }
}
