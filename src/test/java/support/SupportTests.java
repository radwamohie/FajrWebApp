package support;

import base.BaseTests;
import org.testng.annotations.Test;

public class SupportTests extends BaseTests {

    @Test
    public void testOpeningSupportFromHintMessage(){
        homePage.clickSupportFromHintMessage();
        getWindowManager().switchToWindow("Discord");


    }
    @Test
    public void testOpeningSupportFromrHintMessage(){

    }
    @Test
    public void testOpeningSupportFrdomHintMessage(){

    }
}
