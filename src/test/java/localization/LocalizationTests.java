package localization;

import base.BaseTests;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class LocalizationTests extends BaseTests {

    @Test(priority = 1)
    @Step("Test Case 002")
    public void testArabicLangInHomePage()throws Exception {
        Thread.sleep(1000);
        calendarPage.switchToArabicLang();
        String[] expected = new String[]{"انشر الكلمة وساعد المزيد من المسلمين على إعطاء الأولوية لصلواتهم","قم بإنشاء تقويم فجر الآن!"};
        String[] actual = new String[]{calendarPage.getArabicHeaderTitle(), calendarPage.getArabicBodyContent()};
        String[] message = new String[]{"wrong title in arabic", "wrong body content in arabic"};
        assertArrayEquals(expected,actual);
    }



}
