package externalLinks;

import Pages.DiscordPage;
import base.BaseTests;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class ExternalLinksTests extends BaseTests {

    @Test(priority = 10)
    @Step("Test Case 011")
    public void testBlink22Website(){
        homePage.clickOnBlinkLink();
        getWindowManager().switchToWindow("Global Software Development for Startups and Enterprises");

    }
    @Test(priority = 11)
    @Step("Test Case 012")
    public void testJetaiLabsWebsite(){
        homePage.clickOnJetaLabsLink();
        getWindowManager().switchToWindow("Jetai Labs");

    }

}
