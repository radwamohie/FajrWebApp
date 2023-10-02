package support;

import Pages.DiscordPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SupportTests extends BaseTests {

    @Test (priority = 0)
    public void testOpeningSupportFromHintMessage(){
        DiscordPage discordPage = homePage.clickSupportFromHintMessage();
        getWindowManager().switchToWindow("Discord");
        assertEquals(discordPage.getFajrAppLabel(),"Fajr App","Discord page is wrong");

    }
    @Test(priority = 1)
    public void testOpeningSupportFromSupportMessage(){
        DiscordPage discordPage = homePage.clickSupportFromSupportMessage();
        getWindowManager().switchToWindow("Discord");

        assertEquals(discordPage.getFajrAppLabel(),"Fajr App","Discord page is wrong");

    }
    @Test(priority = 2)
    public void testOpeningSupportFromFooter(){
        DiscordPage discordPage = homePage.clickSupportFromFooter();
        getWindowManager().switchToWindow("Discord");
        assertEquals(discordPage.getFajrAppLabel(),"Fajr App","Discord page is wrong");
    }
}
