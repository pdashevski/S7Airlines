package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.AutoAndHotelsPage;
import pages.BaggageAndSeatsPage;
import pages.FlightSearchPage;
import pages.TripSearchPage;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected TripSearchPage tripSearchPage;
    protected FlightSearchPage flightSearchPage;
    protected BaggageAndSeatsPage baggageAndSeatsPage;
    protected AutoAndHotelsPage autoAndHotelsPage;

    @BeforeMethod(description = "Browser starting")
    public void browserStart() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tripSearchPage = new TripSearchPage(driver);
        flightSearchPage = new FlightSearchPage(driver);
        baggageAndSeatsPage = new BaggageAndSeatsPage(driver);
        autoAndHotelsPage = new AutoAndHotelsPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Browser closing")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
