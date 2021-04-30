package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.RetryAnalyzer;
import utils.PropertyReader;

public class TripSearchTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "Тест для теста")
    public void openPage() throws InterruptedException {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect("В одну сторону");
        tripSearchPage.airportFrom("DME");
        tripSearchPage.airportTo("OVB");
        System.out.println(System.getProperty(PropertyReader.getProperty("URL")));
    }
}
