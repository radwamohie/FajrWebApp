package externalLinks;

import Pages.DiscordPage;
import base.BaseTests;
import org.testng.annotations.Test;

public class ExternalLinksTests extends BaseTests {

    @Test
    public void testBlink22Website(){
        homePage.clickOnBlinkLink();
        getWindowManager().switchToWindow("Global Software Development for Startups and Enterprises");

    }
    @Test
    public void testJetaiLabsWebsite(){
        homePage.clickOnJetaLabsLink();
        getWindowManager().switchToWindow("Jetai Labs");

    }
}
