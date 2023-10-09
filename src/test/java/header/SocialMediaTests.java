package header;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SocialMediaTests extends BaseTests {

    @Test(priority = 0)
    public void testSharingOnFacebook(){
        homePage.clickOnFacebookIcon();
        getWindowManager().switchToWindow("Post to Facebook");
    }
    @Test(priority = 1)
    public void testSharingOnLinkedin(){
        homePage.clickOnLinkedinIcon();
        getWindowManager().switchToWindow("LinkedIn");
    }
    @Test(priority = 2)
    public void testSharingOnTwitter(){
        homePage.clickOnTwitterIcon();
        getWindowManager().switchToWindow("Login in to Twitter / X");
    }
    @Test(priority = 3)
    public void testSharingOnWhatsapp(){
        homePage.clickOnWhatsappIcon();
        getWindowManager().switchToWindow("WhatsApp");
    }
    @Test(priority = 4)
    public void testSharingOnProductHunt(){
        homePage.clickOnProductHuntIcon();
        getWindowManager().switchToWindow(" Fajr Calendar - Easiest way to add Islamic prayer times to your calendar | Product Hunt");
    }



}
