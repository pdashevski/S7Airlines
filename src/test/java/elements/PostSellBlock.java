package elements;

import elements.base.BaseElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostSellBlock extends BaseElement {

    String label;
    String locator = "//div[@data-qa='%s']";

    public PostSellBlock(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    @Step("Проверка доступности postSell услуг")
    public boolean isPostSellBlockDisplayed() {
        return driver.findElement(By.xpath(String.format(locator, label))).isDisplayed();
    }
}
