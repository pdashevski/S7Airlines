package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.RetryAnalyzer;

public class TripSearchTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "OLOLO")
    public void openPage() throws InterruptedException {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect("В одну сторону");
        tripSearchPage.airportFrom("DME");
        tripSearchPage.airportTo("OVB");
        System.out.println("");
    }
}
