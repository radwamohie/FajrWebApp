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
        setLocation(30,30,1);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(.,'Get')]")).click();
        Thread.sleep(3000);

    }

    @Test
    public void applyDaylightSaving() throws InterruptedException {
        Thread.sleep(5000);
        homePage.clickOnDayLightSavingsButton();
    }

    public void setLocation(int latitude,int longitude,int accuracy){
        Map<String, Object> coordinates = new HashMap<String, Object>();
        coordinates.put("latitude",latitude);
        coordinates.put("longitude",longitude);
        coordinates.put("accuracy",accuracy);
        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
    }







}
