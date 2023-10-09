package calendar;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarTests extends BaseTests {

    //issue with selecting from suggestive dropdown list
    @Test
    public void addAddress() throws InterruptedException {
        homePage.clearAddressField();
        homePage.enterAddress("Alexandria");
        Thread.sleep(3000);
        homePage.selectCountry("Alexandria Egypt");
    }
    //apply test-data + need to find assertions on the change for the prayer times
    @Test
    public void selectCalculationMethod(){
        homePage.selectCalculationMethod("Kuwait");
    }

    @Test
    public void dayLightRadioButtonTest() throws InterruptedException {
        homePage.clickDayLightRadioButton();

    }




}
