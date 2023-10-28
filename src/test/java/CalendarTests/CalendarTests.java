package CalendarTests;

import base.BaseTests;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class CalendarTests extends BaseTests {

    @Test(description = "verify current location by Clicking on Get Location button")
    public void testGetCurrentLocation()throws InterruptedException {
        Thread.sleep(1000);
        calendarPage.clearLocationText();
        Thread.sleep(1000);
        calendarPage.clickOnGetLocationButton();
        String currentLocation = calendarPage.getCurrentLocation();
        assertEquals(currentLocation,"Alexandria Governorate, Egypt","wrong location");
    }

    @Test(description = "verify current location by mocking Geo location")

    public void gettingUserCurrentLocation() throws InterruptedException {
        Map<String, Object> coordinates = new HashMap<String, Object>();
       calendarPage.setLocation(31.205753,29.924526,1);
        Thread.sleep(3000);
        calendarPage.clickOnGetLocationButton();
        Thread.sleep(3000);
        String currentLocation = calendarPage.getCurrentLocation();
        System.out.println(currentLocation);
        assertEquals(currentLocation,"الإسكندرية, مصر","wrong location");
    }


    @Test(priority = 13,description = "verify adding 1 hour to prayers time when check add light saving time")
    @Step("Test Case 014")
    public void testAddingDayLightSavingTime() throws Exception {
        Thread.sleep(1000);
        calendarPage.addDayLightSavingTime();

        //need assertion for prayers times
    }

    @Test(description = "verify create prayers calendar ")

    public void createMyPrayersCalendar()throws Exception {
        Thread.sleep(1000);
        calendarPage.scrollToPageBottom();
        Thread.sleep(1000);
        calendarPage.createMyPrayersCalendar();
        Thread.sleep(3000);
        String calendarCreationMessage = calendarPage.getCalendarCreationMessage();
        assertEquals(calendarCreationMessage,"Your calendar has been updated successfully","calendar is not created");
    }
    @Test(dependsOnMethods={"createMyPrayersCalendar"})
    public void unSyncFromPrayersCalendar()throws Exception{
        Thread.sleep(1000);
        calendarPage.scrollToPageBottom();
        Thread.sleep(1000);
        calendarPage.unSyncFromCalendar();
        Thread.sleep(1000);
        calendarPage.removeCalendar();
    }



}
