package tests;

import models.AdultPassenger;
import models.Contacts;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class PaymentTest extends BaseTest {

    @Test(description = "Оплата. Проверка выбранного пола пассажира")
    public void paymentPageSexRadioCheckSelection() {
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
        paymentPage.sexSelect();
        Assert.assertTrue(paymentPage.sexRadioButtonPresent(), "Пол пассажира не совпал с выбранным");
    }

    @Test(description = "Оплата. Проверка идентичности введенных и отображаемых данных пассажира")
    public void paymentPagePassengerDataCheck() {
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
        AdultPassenger adultPassenger = new AdultPassenger(
                "Petr",
                "Petrikov",
                "01.01.1990",
                "1234 567890"
        );
        paymentPage.createPassengerDetails(adultPassenger);
        //paymentPage.formSubmitPassengerData();
        Assert.assertEquals(paymentPage.firstNamePassengerField(),
                adultPassenger.getFirstName(), "Фамилии не идентичны");
        Assert.assertEquals(paymentPage.lastNamePassengerField(),
                adultPassenger.getLastName(), "Имена не идентичны");
        Assert.assertEquals(paymentPage.dateOfirthPassengerField(),
                adultPassenger.getDateOfBirth(), "Даты рождения не идентичны");
        Assert.assertEquals(paymentPage.documentNumberOfPassengerField(),
                adultPassenger.getDocumentNumber(), "Номера документов не идентичны");
    }

    @Test(description = "Оплата. Проверка идентичности введенных и отображаемых контактных данных пассажира")
    public void paymentPagePassengerContactDataCheck() {
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
        Contacts contacts = new Contacts(
                "3697777777",
                "test@test.com"
        );
        //paymentPage.formSubmitPassengerData();
        paymentPage.createPassengerContacts(contacts);
        Assert.assertEquals(paymentPage.phonePassengerField(),
                contacts.getTelephoneNumber(),
                "Телефонные номера не идентичны");
        Assert.assertEquals(paymentPage.emailPassengerField(),
                contacts.getEmail(),
                "Email адреса не идентичны");
    }

    @Test(description = "Оплата. Создание бронирования с данными пассажира")
    public void paymentPageCheckRedirectionToTheConfirmPage() {
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
        paymentPage.sexSelect();
        AdultPassenger adultPassenger = new AdultPassenger(
                "Petr",
                "Petrikov",
                "01.01.1990",
                "1234 567890"
        );
        paymentPage.createPassengerDetails(adultPassenger);
        Contacts contacts = new Contacts(
                "3697777777",
                "test@test.com"
        );
        paymentPage.formSubmitPassengerData();
        paymentPage.createPassengerContacts(contacts);
        paymentPage.onHoldPayment();
        paymentPage.confirmCheckboxSelect();
        paymentPage.submitPassenger();
        System.out.println(confirmPage.getPNR());
    }
}
