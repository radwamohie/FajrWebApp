package support;

import Pages.DiscordPage;
import base.BaseTests;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SupportTests extends BaseTests {

    @Test (priority = 4)
    @Step("Test Case 003")
    public void testOpeningSupportFromHintMessage(){
        DiscordPage discordPage = homePage.clickSupportFromHintMessage();
        getWindowManager().switchToWindow("Discord");
        assertEquals(discordPage.getFajrAppLabel(),"Fajr App","Discord page is wrong");

    }
    @Test(priority = 3)
    @Step("Test Case 004")
    public void testOpeningSupportFromSupportMessage(){
        DiscordPage discordPage = homePage.clickSupportFromSupportMessage();
        getWindowManager().switchToWindow("Discord");
        assertEquals(discordPage.getFajrAppLabel(),"Fajr App","Discord page is wrong");

    }
    @Test(priority = 2)
    @Step("Test Case 005")
    public void testOpeningSupportFromFooter(){
        DiscordPage discordPage = homePage.clickSupportFromFooter();
        getWindowManager().switchToWindow("Discord");
        assertEquals(discordPage.getFajrAppLabel(),"Fajr App","Discord page is wrong");
    }
}
