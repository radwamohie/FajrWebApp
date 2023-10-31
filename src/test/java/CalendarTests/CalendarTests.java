package CalendarTests;

import base.BaseTests;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

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
    public void testAddingDayLightSavingTime() throws InterruptedException {
        Thread.sleep(3000);
        String fajrTimeBefore = calendarPage.getFajrPrayerTimeAsString();
        String fajrTimeBeforeStripped = fajrTimeBefore.replaceAll(" AM", " ");

        String fajrTrimmedBefore = fajrTimeBeforeStripped.trim();
        System.out.println(fajrTrimmedBefore);

        Thread.sleep(1000);
        calendarPage.addDayLightSavingTime();
        Thread.sleep(1000);
        String fajrTimeAfter = calendarPage.getFajrPrayerTimeAsString();
        String fajrTimeAfterStripped = fajrTimeAfter.replaceAll(" AM", " ");
        String fajrTrimmedAfter = fajrTimeAfterStripped.trim();
        System.out.println(fajrTrimmedAfter);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime dateTime1= LocalTime.parse(fajrTrimmedAfter, formatter);
        LocalTime dateTime2= LocalTime.parse(fajrTrimmedBefore, formatter);

        long diffInHours = java.time.Duration.between(dateTime2, dateTime1).toHours();
        System.out.println(diffInHours);

        assertEquals(diffInHours,1,"invalid daylight time saving");
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
