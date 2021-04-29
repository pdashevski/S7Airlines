package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.TripSearchPage;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    protected TripSearchPage tripSearchPage;

    @BeforeMethod(description = "Browser opening")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        tripSearchPage = new TripSearchPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Browser closing")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
