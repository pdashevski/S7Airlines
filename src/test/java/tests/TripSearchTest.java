package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.RetryAnalyzer;

public class TripSearchTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "Тест для теста")
    public void openPage() throws InterruptedException {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect("В одну сторону");
        tripSearchPage.airportFrom("DME");
        tripSearchPage.airportTo("OVB");
        tripSearchPage.calendarClickButton("Туда");
        tripSearchPage.calendarSelectMonthAndDay("май", "15");
        tripSearchPage.searchSubmit();
        flightSearchPage.selectFare();
        flightSearchPage.submit();
        System.out.println();
    }

    @Test
    public void fh() {
        tripSearchPage.open();
    }
}
