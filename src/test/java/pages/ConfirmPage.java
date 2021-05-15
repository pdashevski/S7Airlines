package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ConfirmPage extends BasePage {

    String purchasedProductsBeforeCLick = "//div[@class='purchased-products js_purchased_products_content']";
    String purchasedProductsAfterCLick = "//div[@class='purchased-products js_purchased_products_content active']";
    String locatorPNR = "//div[@class='flights-pnr']/strong";

    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    public void expandPurchaseProductsBlock() {
        try {
            Thread.sleep(25000);
            driver.findElement(By.xpath(purchasedProductsBeforeCLick)).click();
        } catch (Exception e) {
            System.out.println("Error at confirmPageWaiting method!!!!");
        }
        driver.findElement(By.xpath(purchasedProductsAfterCLick)).click();
    }

    @Step("Получаем уникальный идентификатор брони")
    public String getPNR() {
        expandPurchaseProductsBlock();
        return driver.findElement(By.xpath(locatorPNR)).getText();
    }
}
