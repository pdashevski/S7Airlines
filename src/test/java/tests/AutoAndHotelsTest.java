package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class AutoAndHotelsTest extends BaseTest {

    @Test
    public void asd() {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect(WAY);
        tripSearchPage.airportFrom(AIRPORT_FROM);
        tripSearchPage.airportTo(AIRPORT_TO);
        tripSearchPage.calendarClickButton(CALENDAR_FROM);
        tripSearchPage.calendarSelectMonthAndDay(MONTH, DAY_NUMBER);
        tripSearchPage.searchSubmit();
        flightSearchPage.selectFare();
        flightSearchPage.flightSubmit();
        baggageAndSeatsPage.autoAndHotelsSubmit();
        autoAndHotelsPage.baggageAndSeatsSubmit();
        //TODO
    }
}
