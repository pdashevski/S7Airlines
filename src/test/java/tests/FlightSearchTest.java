package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.RetryAnalyzer;

public class FlightSearchTest extends BaseTest {

    @Test(description = "Выбор рейса. Проверка на совпадение выбранного рейса (до подтверждения и после)")
    public void flighSearchCheckDepaAndArriveTimeForFare() {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect(WAY);
        tripSearchPage.airportFrom(AIRPORT_FROM);
        tripSearchPage.airportTo(AIRPORT_TO);
        tripSearchPage.calendarClickButton(CALENDAR_FROM);
        tripSearchPage.calendarSelectMonthAndDay(MONTH, DAY_NUMBER);
        tripSearchPage.searchSubmit();
        flightSearchPage.selectFare();
        String timeDepBefore = flightSearchPage.getTimeDepartureBeforeSelect();
        String timeArrBefore = flightSearchPage.getTimeArrivalBeforeSelect();

        Assert.assertEquals(timeDepBefore,
                flightSearchPage.getTimeDepartureAfterSelect(),
                "Выбранное время вылета не совпадает с текущиим");
        Assert.assertEquals(timeArrBefore,
                flightSearchPage.getTimeArrivalAfterSelect(),
                "Выбранное время прибытия не совпадает с текущиим");
    }

    //TODO добавить тест на проверку совпадения тарифа

    @Test(description = "Выбор рейса. Переход на страницу добавления багажа и выбора мест")
    public void flighSearchCheckBagAndSeatsPageRedirectionWithUserData() {
        tripSearchPage.open();
        tripSearchPage.tripTypeRadioButtonSelect(WAY);
        tripSearchPage.airportFrom(AIRPORT_FROM);
        tripSearchPage.airportTo(AIRPORT_TO);
        tripSearchPage.calendarClickButton(CALENDAR_FROM);
        tripSearchPage.calendarSelectMonthAndDay(MONTH, DAY_NUMBER);
        tripSearchPage.searchSubmit();
        flightSearchPage.selectFare();
        flightSearchPage.flightSubmit();
        Assert.assertTrue(baggageAndSeatsPage.isPageOpened(), "Не удалось открыть страницу выбора услуг");
    }
}
