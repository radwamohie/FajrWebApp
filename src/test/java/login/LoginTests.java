package login;

import base.BaseTests;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class LoginTests extends BaseTests {

    @Test
    public void testLoginCredentialsByGmail(){
        String[] expected = new String[]{"Radwa Mohie","radwa.mohie@blink22.com"};
        String[] actual = new String[]{homePage.getLoginName(), homePage.getLoginEmail()};
        String[] message = new String[]{"wrong name", "wrong email"};
        assertArrayEquals(expected,actual);
    }

}
