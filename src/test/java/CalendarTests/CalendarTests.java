package CalendarTests;

import Pages.BasePage;
import base.BaseTests;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
public class CalendarTests extends BaseTests {

    @Test(priority = 12)
    @Step("Test Case 013")
    public void testGetCurrentLocation(){
        homePage.clearLocationText();
        homePage.clickOnGetLocationButton();
        String currentLocation = homePage.getCurrentLocation();
        assertEquals(currentLocation,"الإسكندرية, مصر","wrong location");
    }

    @Test(priority = 13)
    @Step("Test Case 014")
    public void testAddingDayLightSavingTime() throws InterruptedException {
        Thread.sleep(5000);
        homePage.addDayLightSavingTime();
    }

    @Test(priority = 14)
    @Step("Test Case 015")
    public void createMyPrayersCalendar(){
        homePage.createMyPrayersCalendar();
    }


}
