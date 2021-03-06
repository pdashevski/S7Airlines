package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class BaggageAndSeatsTest extends BaseTest {

    public static final String POSTSELL_SEATS = "seats";
    public static final String POSTSELL_MEAL = "meal";

    @Test(description = "Выбор услуг. Проверка блока с местами")
    public void baggageAndSeatsCheckAdditionalSeats() {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect(WAY);
        tripSearchPage.writeToFromInput(AIRPORT_FROM);
        tripSearchPage.writeToToInput(AIRPORT_TO);
        tripSearchPage.calendarClickButton(CALENDAR_FROM);
        tripSearchPage.calendarSelectMonthAndDay(MONTH, DAY_NUMBER);
        tripSearchPage.searchSubmit();
        flightSearchPage.selectFare();
        flightSearchPage.flightSubmit();
        Assert.assertTrue(baggageAndSeatsPage.postSellProductsSelecting(POSTSELL_SEATS), "Блок с местами не найден на странице");
    }

    @Test(description = "Выбор услуг. Проверка блока с питанием")
    public void baggageAndSeatsCheckAdditionalMeal() {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect(WAY);
        tripSearchPage.writeToFromInput(AIRPORT_FROM);
        tripSearchPage.writeToToInput(AIRPORT_TO);
        tripSearchPage.calendarClickButton(CALENDAR_FROM);
        tripSearchPage.calendarSelectMonthAndDay(MONTH, DAY_NUMBER);
        tripSearchPage.searchSubmit();
        flightSearchPage.selectFare();
        flightSearchPage.flightSubmit();
        Assert.assertTrue(baggageAndSeatsPage.postSellProductsSelecting(POSTSELL_MEAL), "Блок с питанием не найден на странице");
    }

    @Test(description = "Выбор услуг. Проверка блока с питанием")
    public void baggageAndSeatsCheckAutoAndHotelsRedirectionWithUserData() {
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
        Assert.assertTrue(autoAndHotelsPage.autoAndHotelsCarIsDisplayed(), "Не удалось открыть страницу выбора отелей");
    }
}
