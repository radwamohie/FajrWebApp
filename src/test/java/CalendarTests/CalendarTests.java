package CalendarTests;

import Pages.BasePage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalendarTests extends BaseTests {

    @Test
    public void testGetCurrentLocation(){
        homePage.clearLocationText();
        homePage.clickOnGetLocationButton();
        String currentLocation = homePage.getCurrentLocation();
        assertEquals(currentLocation,"Alexandria Governorate, Egypt","wrong location");
    }




}
