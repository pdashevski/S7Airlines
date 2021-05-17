package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class TripSearchTest extends BaseTest {

    @Test(description = "Поиск путешествия. Проверка аэропортов")
    public void tripSearchCheckingOriginAndDestination() {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect(WAY);
        tripSearchPage.writeToFromInput(AIRPORT_FROM);
        tripSearchPage.writeToToInput(AIRPORT_TO);
        Assert.assertEquals(tripSearchPage.getAirportFromValue(), "Москва, Домодедово, Россия", "Аэропорт вылета не был найден");
        Assert.assertEquals(tripSearchPage.getAirportToValue(), "Сочи, Россия", "Аэропорт прибытия не был найден");
    }

    @Test(description = "Поиск путешествия. Провекра даты вылета")
    public void tripSearchCheckingCalendarData() {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect(WAY);
        tripSearchPage.writeToFromInput(AIRPORT_FROM);
        tripSearchPage.writeToToInput(AIRPORT_TO);
        tripSearchPage.calendarClickButton(CALENDAR_FROM);
        tripSearchPage.calendarSelectMonthAndDay(MONTH, DAY_NUMBER);
        Assert.assertEquals(tripSearchPage.getCalendarDate(), "26.05.2021", "Дата вылета не совпадает");
    }

    @Test(description = "Поиск путешествия. Переход на страницу выбора рейса")
    public void tripSearchCheckFlightPageRedirectionWithUserData() {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect(WAY);
        tripSearchPage.writeToFromInput(AIRPORT_FROM);
        tripSearchPage.writeToToInput(AIRPORT_TO);
        tripSearchPage.calendarClickButton(CALENDAR_FROM);
        tripSearchPage.calendarSelectMonthAndDay(MONTH, DAY_NUMBER);
        tripSearchPage.searchSubmit();
        Assert.assertTrue(flightSearchPage.isPageOpened(), "Не удалось открыть страницу выбора рейса");
    }

    /*@Test(retryAnalyzer = RetryAnalyzer.class, description = "Тест для проверки работоспособности фреймворка")
    public void openPage() throws InterruptedException {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect("В одну сторону");
        tripSearchPage.airportFrom("DME");
        tripSearchPage.airportTo("OVB");
        tripSearchPage.calendarClickButton("Туда");
        tripSearchPage.calendarSelectMonthAndDay("май", "25");
        tripSearchPage.searchSubmit();
        flightSearchPage.selectFare();
        flightSearchPage.flightSubmit();
        baggageAndSeatsPage.autoAndHotelsSubmit();
        autoAndHotelsPage.baggageAndSeatsSubmit();
        AdultPassenger adultPassenger = new AdultPassenger(
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
        paymentPage.createPassengerDetails(adultPassenger);
        paymentPage.createPassengerContacts(contacts);
        paymentPage.onHoldPayment();
        paymentPage.confirmCheckboxSelect();
        paymentPage.submitPassenger();
        System.out.println(confirmPage.getPNR());
    }*/
}
