package localization;

import Pages.HomePage;
import base.BaseTests;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class LocalizationTests extends BaseTests {

    @Test(priority = 1)
    @Step("Test Case 002")
    public void testArabicLangInHomePage(){
        homePage.switchToArabicLang();
        String[] expected = new String[]{"انشر الكلمة وساعد المزيد من المسلمين على إعطاء الأولوية لصلواتهم","قم بإنشاء تقويم فجر الآن!"};
        String[] actual = new String[]{homePage.getArabicHeaderTitle(), homePage.getArabicBodyContent()};
        String[] message = new String[]{"wrong title in arabic", "wrong body content in arabic"};
        assertArrayEquals(expected,actual);
    }



}
