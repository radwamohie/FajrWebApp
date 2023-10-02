package localization;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class LocalizationTests extends BaseTests {

    @Test
    public void testArabicLangInHomePage(){
        homePage.switchToArabicLang();
        String[] expected = new String[]{"انشر الكلمة وساعد المزيد من المسلمين على إعطاء الأولوية لصلواتهم", "احجز فترات لصلواتك في تقويمك بطريقة مرنة و سهلة"};
        String[] actual = new String[]{homePage.getArabicHeaderTitle(), homePage.getArabicBodyContent()};
        String[] message = new String[]{"wrong title in arabic", "wrong body content in arabic"};
        assertArrayEquals(expected,actual);
    }
    @Test
    public void testArabicLangInPrivacyPage(){

        //waiting localization issue to be fixed


    }




}
