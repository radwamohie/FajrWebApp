package support;

import Pages.DiscordPage;
import base.BaseTests;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SupportTests extends BaseTests {

    @Test (priority = 4)
    @Step("Test Case 003")
    public void testOpeningSupportFromHintMessage()throws Exception {
        Thread.sleep(1000);
        DiscordPage discordPage = calendarPage.clickSupportFromHintMessage();
        getWindowManager().switchToWindow("Discord");
        assertEquals(discordPage.getFajrAppLabel(),"Fajr App","Discord page is wrong");

    }
    @Test(priority = 3)
    @Step("Test Case 004")
    public void testOpeningSupportFromSupportMessage()throws Exception {
        Thread.sleep(1000);
        DiscordPage discordPage = calendarPage.clickSupportFromSupportMessage();
        getWindowManager().switchToWindow("Discord");
        assertEquals(discordPage.getFajrAppLabel(),"Fajr App","Discord page is wrong");

    }
    @Test(priority = 2)
    @Step("Test Case 005")
    public void testOpeningSupportFromFooter()throws Exception {
        Thread.sleep(1000);
        DiscordPage discordPage = calendarPage.clickSupportFromFooter();
        getWindowManager().switchToWindow("Discord");
        assertEquals(discordPage.getFajrAppLabel(),"Fajr App","Discord page is wrong");
    }
}
