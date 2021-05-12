package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class AutoAndHotelsPage extends BasePage {

    public static final String submitButton = "//span[contains(text(),'Перейти к оплате')]/ancestor::button";
    public static final String carGod = "//div[@class='travel-shop-item']/div[@data-qa='car']";

    public AutoAndHotelsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Подтверждение формы выбора услуг и прохождение далее по флоу")
    public void baggageAndSeatsSubmit() {
        isElementPresent(By.xpath(submitButton));
        driver.findElement(By.xpath(submitButton)).click();
    }

    @Step("Проверка отображение элементов на странице отелей")
    public boolean autoAndHotelsCarIsDisplayed() {
        return driver.findElement(By.xpath(carGod)).isDisplayed();
    }
}
