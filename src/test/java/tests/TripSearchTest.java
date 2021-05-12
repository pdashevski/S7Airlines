package tests;

import models.Contacts;
import models.AdultPassenger;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.RetryAnalyzer;

public class TripSearchTest extends BaseTest {

    public static final String WAY = "В одну сторону";
    public static final String AIRPORT_FROM = "DME";
    public static final String AIRPORT_TO = "OVB";
    public static final String CALENDAR_FROM = "Туда";
    public static final String MONTH = "май";
    public static final String DAY_NUMBER = "26";

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "Тестовый тест на полное флоу")
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
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "Создание путешествия. Проверка аэропортов")
    public void tripCreationCheckingOriginAndDestination() {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect(WAY);
        tripSearchPage.airportFrom(AIRPORT_FROM);
        tripSearchPage.airportTo(AIRPORT_TO);
        Assert.assertEquals(tripSearchPage.getAirportFromValue(), "Москва, Домодедово, Россия", "Аэропорт вылета не был найден");
        Assert.assertEquals(tripSearchPage.getAirportToValue(), "Новосибирск, Россия", "Аэропорт прибытия не был найден");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "Создание путешествия. Провекра даты вылета")
    public void tripCreationCheckingCalendarData() {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect(WAY);
        tripSearchPage.airportFrom(AIRPORT_FROM);
        tripSearchPage.airportTo(AIRPORT_TO);
        tripSearchPage.calendarClickButton(CALENDAR_FROM);
        tripSearchPage.calendarSelectMonthAndDay(MONTH, DAY_NUMBER);
        Assert.assertEquals(tripSearchPage.getCalendarDate(), "26.05.2021", "Дата вылета не совпадает");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "Создание путешествия. Переход на страницу выбора рейса")
    public void tripCreationCheckFlightPageRedirectionWithUserData() {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect(WAY);
        tripSearchPage.airportFrom(AIRPORT_FROM);
        tripSearchPage.airportTo(AIRPORT_TO);
        tripSearchPage.calendarClickButton(CALENDAR_FROM);
        tripSearchPage.calendarSelectMonthAndDay(MONTH, DAY_NUMBER);
        tripSearchPage.searchSubmit();
        Assert.assertTrue(flightSearchPage.isPageOpened(), "Не удалось открыть страницу выбора рейса");
    }
}
