package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected TripSearchPage tripSearchPage;
    protected FlightSearchPage flightSearchPage;
    protected BaggageAndSeatsPage baggageAndSeatsPage;
    protected AutoAndHotelsPage autoAndHotelsPage;
    protected PaymentPage paymentPage;
    protected ConfirmPage confirmPage;

    public static final String WAY = "В одну сторону";
    public static final String AIRPORT_FROM = "DME";
    public static final String AIRPORT_TO = "AER";
    public static final String CALENDAR_FROM = "Туда";
    public static final String MONTH = "май";
    public static final String DAY_NUMBER = "26";

    @BeforeMethod(description = "Browser starting")
    public void browserStart(ITestContext iTestContext) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--disable-blink-features=BlockCredentialedSubresources");
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("user-agent=\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36\"");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        iTestContext.setAttribute("driver", driver);
        tripSearchPage = new TripSearchPage(driver);
        flightSearchPage = new FlightSearchPage(driver);
        baggageAndSeatsPage = new BaggageAndSeatsPage(driver);
        autoAndHotelsPage = new AutoAndHotelsPage(driver);
        paymentPage = new PaymentPage(driver);
        confirmPage = new ConfirmPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Browser closing")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
