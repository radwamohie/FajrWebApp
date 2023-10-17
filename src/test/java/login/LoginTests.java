package login;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class LoginTests extends BaseTests {

    @Test(priority = 0 , description = "verify logged in email and user name")
    @Step("Test Case 001")
    @Severity(SeverityLevel.BLOCKER)

    public void testLoginCredentialsByGmail(){
        String[] expected = new String[]{"Radwa Mohie","radwa.mohie@blink22.com"};
        String[] actual = new String[]{homePage.getLoginName(), homePage.getLoginEmail()};
        String[] message = new String[]{"wrong name", "wrong email"};
        assertArrayEquals(expected,actual);
    }
}
