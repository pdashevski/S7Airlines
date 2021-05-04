package tests;

import models.Contacts;
import models.Passenger;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.RetryAnalyzer;

public class TripSearchTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "Тестовый тест на полное флоу")
    public void openPage() throws InterruptedException {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect("В одну сторону");
        tripSearchPage.airportFrom("DME");
        tripSearchPage.airportTo("OVB");
        tripSearchPage.calendarClickButton("Туда");
        tripSearchPage.calendarSelectMonthAndDay("май", "15");
        tripSearchPage.searchSubmit();
        flightSearchPage.selectFare();
        flightSearchPage.flightSubmit();
        baggageAndSeatsPage.autoAndHotelsSubmit();
        autoAndHotelsPage.baggageAndSeatsSubmit();
        Passenger passenger = new Passenger(
                "Petr",
                "Petrikov",
                "01.01.1990",
                "1234567890"
        );
        Contacts contacts = new Contacts(
                "36977777777",
                "test@test.com"
        );
        paymentPage.sexSelect();
        paymentPage.createPassengerDetails(passenger);
        paymentPage.createPassengerContacts(contacts);
        paymentPage.onHoldPayment();
        paymentPage.confirmCheckboxSelect();
        paymentPage.submitPassenger();
        System.out.println();
    }
}
