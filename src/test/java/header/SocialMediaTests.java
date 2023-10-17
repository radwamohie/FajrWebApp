package header;

import base.BaseTests;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SocialMediaTests extends BaseTests {

    @Test(priority = 5)
    @Step("Test Case 006")
    public void testSharingOnFacebook(){
        homePage.clickOnFacebookIcon();
        getWindowManager().switchToWindow("Post to Facebook");
    }
    @Test(priority = 6)
    @Step("Test Case 007")
    public void testSharingOnLinkedin(){
        homePage.clickOnLinkedinIcon();
        getWindowManager().switchToWindow("LinkedIn");
    }
    @Test(priority = 7)
    @Step("Test Case 008")
    public void testSharingOnTwitter(){
        homePage.clickOnTwitterIcon();
        getWindowManager().switchToWindow("Login in to Twitter / X");
    }
    @Test(priority = 8)
    @Step("Test Case 009")
    public void testSharingOnWhatsapp(){
        homePage.clickOnWhatsappIcon();
        getWindowManager().switchToWindow("WhatsApp");
    }
    @Test(priority = 9)
    @Step("Test Case 010")
    public void testSharingOnProductHunt(){
        homePage.clickOnProductHuntIcon();
        getWindowManager().switchToWindow(" Fajr Calendar - Easiest way to add Islamic prayer times to your calendar | Product Hunt");
    }


}
