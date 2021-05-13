package pages;

import elements.PostSellBlock;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class BaggageAndSeatsPage extends BasePage {

    public static final String submitButton = "//span[contains(text(),'Далее')]/ancestor::button";
    public static final String pageMainLocator = "//h2[contains(text(),'Выберите услуги для комфортной поездки')]";
    public static final String meal = "meal_postSellBlock";
    public static final String seats = "seat_postSellBlock";

    public BaggageAndSeatsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Отправляем форму и переходим дальше по флоу")
    public void autoAndHotelsSubmit() {
        isElementPresent(By.xpath(submitButton));
        driver.findElement(By.xpath(submitButton)).click();
    }

    @Step("Проверка страницы BaggageAndSeats на переход с предыдущей страницы")
    public boolean isPageOpened() {
        return driver.findElement(By.xpath(pageMainLocator)).isDisplayed();
    }

    @Step("Проверка продуктов на странца")
    public boolean postSellProductsSelecting(String postSellType) {
        if (postSellType.equals(meal)) {
            return new PostSellBlock(driver, meal).isPostSellBlockDisplayed();
        } else return new PostSellBlock(driver, seats).isPostSellBlockDisplayed();
    }
}
