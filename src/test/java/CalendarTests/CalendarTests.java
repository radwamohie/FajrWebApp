package CalendarTests;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class CalendarTests extends BaseTests {

    @Test
    public void testGetCurrentLocation(){
        homePage.clearLocationText();
        homePage.clickOnGetLocationButton();
        String currentLocation = homePage.getCurrentLocation();
        assertEquals(currentLocation,"Alexandria Governorate, Egypt","wrong location");
    }
    @Test
    public void gettingUserCurrentLocation() throws InterruptedException {
        Map<String, Object> coordinates = new HashMap<String, Object>();
        coordinates.put("latitude",30);
        coordinates.put("longitude",30);
        coordinates.put("accuracy",1);
        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        //driver.get("https://stg-calendar.fajrapp.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(.,'Get')]")).click();
        Thread.sleep(3000);

    }

    public void setLocation(int latitude,int longitude,int accuracy){
        Map<String, Object> coordinates = new HashMap<String, Object>();
        coordinates.put("latitude",latitude);
        coordinates.put("longitude",longitude);
        coordinates.put("accuracy",accuracy);
        //driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
    }







}
