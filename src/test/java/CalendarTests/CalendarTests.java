package CalendarTests;

import base.BaseTests;
import org.testng.annotations.Test;
import java.time.*;

import static org.testng.Assert.assertEquals;

public class CalendarTests extends BaseTests {

    @Test(priority = 1, description = "verify current location by enter city name")
    public void EnterCurrentLocation()throws InterruptedException {
        Thread.sleep(1000);
        calendarPage.clearLocationText();
        Thread.sleep(1000);
        calendarPage.enterCity("Texas City, United States");
        Thread.sleep(3000);
        String currentLocation = calendarPage.getCurrentLocation();
        System.out.println( "entered location is " + currentLocation);
        assertEquals(currentLocation,"Texas City, United States","wrong location");
    }

    @Test(priority = 2,description = "verify current location by Clicking on Get Location button")
    public void GetCurrentLocation()throws InterruptedException {
        Thread.sleep(1000);
        calendarPage.clearLocationText();
        Thread.sleep(1000);
        calendarPage.clickOnGetLocationButton();
        String currentLocation = calendarPage.getCurrentLocation();
        assertEquals(currentLocation,"Alexandria, Egypt","wrong location");
    }

    @Test(priority = 3,description = "verify current location by mocking Geo location")
    public void gettingUserCurrentLocationUsingfakeLocation() throws InterruptedException {
        calendarPage.setLocation(19.075983,72.877655,1);//India
        calendarPage.clickOnGetLocationButton();
        String currentLocation = calendarPage.getCurrentLocation();
        System.out.println(currentLocation);
        assertEquals(currentLocation,"Mumbai, India","wrong location");
    }

    @Test(priority = 4,description = "verify adding 1 hour to prayers time when check add light saving time")
    public void AddingDayLightSavingTime() throws InterruptedException {
        Thread.sleep(2000);
        String fajrTimeBefore = calendarPage.getFajrPrayerTimeAsString();
        System.out.println(fajrTimeBefore);

        String fajrTimeTrimmedBefore=calendarPage.removingAMFromFajrTime(fajrTimeBefore);
        System.out.println(fajrTimeTrimmedBefore);
        LocalTime fajrTimeBefore1 = calendarPage.parseFajrStringToTime(fajrTimeTrimmedBefore);
        System.out.println(fajrTimeBefore1);

        calendarPage.addDayLightSavingTime();

        Thread.sleep(1000);
        String fajrTimeAfter = calendarPage.getFajrPrayerTimeAsString();
        System.out.println(fajrTimeAfter);

        String fajrTimeTrimmedAfter=calendarPage.removingAMFromFajrTime(fajrTimeAfter);
        System.out.println(fajrTimeTrimmedAfter);

        LocalTime fajrTimeAfter1 = calendarPage.parseFajrStringToTime(fajrTimeTrimmedAfter);
        System.out.println(fajrTimeAfter1);

        long durationInHours = calendarPage.durationBetweenPrayertimeInHours(fajrTimeBefore1,fajrTimeAfter1);
        System.out.println(durationInHours);

        assertEquals( durationInHours,1,"invalid daylight time saving");
    }


    @Test(priority = 5,description = "verify create prayers calendar ")
    public void createMyPrayersCalendar()throws Exception {
        Thread.sleep(3000);
        calendarPage.scrollToPageBottom();
       if(calendarPage.checkRemoveCalendarButtonExist() == true ) {
            Thread.sleep(3000);
            calendarPage.ClickOnRemoveCalendar();
            Thread.sleep(3000);
            calendarPage.clickOnunSyncFromCalendar();
            Thread.sleep(3000);
            calendarPage.createMyPrayersCalendar();
        } else {
            Thread.sleep(3000);
            calendarPage.createMyPrayersCalendar();
        }
      Thread.sleep(3000);
    // calendarPage.createMyPrayersCalendar();
     //   Thread.sleep(3000);
      calendarPage.addingPrayerTimesAddingAuto();
        Thread.sleep(3000);
       calendarPage.connectToGoogle();
        String calendarCreationMessage = calendarPage.getCalendarCreationMessage();
        assertEquals(calendarCreationMessage,"Your calendar has been updated successfully","calendar is not created");
    }
    @Test(priority = 6,description = "verify unSyncing from prayers calendar ") //dependsOnMethods={"createMyPrayersCalendar"}
    public void unSyncFromPrayersCalendar()throws Exception{
        Thread.sleep(1000);
        calendarPage.scrollToPageBottom();
        Thread.sleep(1000);
        calendarPage.ClickOnRemoveCalendar();
        Thread.sleep(1000);
        calendarPage.clickOnunSyncFromCalendar();
    }

    @Test(priority = 7,description = "verify prayers settings")
    public void prayerSetting()throws Exception{
        Thread.sleep(1000);
       String value = calendarPage.getIshaaCheck();
        System.out.println(value);
    }


}
