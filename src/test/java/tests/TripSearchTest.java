package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.RetryAnalyzer;

public class TripSearchTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "OLOLO")
    public void openPage() {
        tripSearchPage.open();
        System.out.println("");
    }
}
