package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class AutoAndHotelsTest extends BaseTest {

    @Test(description = "Авто и Отели. Проверка перехода на страницу оплаты брони")
    public void autoAndHotelsPageCheckRedirectionToPaymentWithUserData() {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect(WAY);
        tripSearchPage.writeToFromInput(AIRPORT_FROM);
        tripSearchPage.writeToToInput(AIRPORT_TO);
        tripSearchPage.calendarClickButton(CALENDAR_FROM);
        tripSearchPage.calendarSelectMonthAndDay(MONTH, DAY_NUMBER);
        tripSearchPage.searchSubmit();
        flightSearchPage.selectFare();
        flightSearchPage.flightSubmit();
        baggageAndSeatsPage.autoAndHotelsSubmit();
        autoAndHotelsPage.baggageAndSeatsSubmit();
        Assert.assertTrue(paymentPage.isPageOpened(), "Не удалось открыть страницу оплаты");
    }
}
