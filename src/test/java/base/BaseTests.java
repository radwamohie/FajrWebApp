package base;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.WindowManager;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    private By homeButton = By.cssSelector("img[class='MuiBox-root css-1yje24i']");

    @BeforeClass
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        goHome();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://stg-calendar.fajrapp.com/");
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }
    @AfterClass
    public  void tearDown(){
     driver.quit();
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new  ChromeOptions();
      //  options.setHeadless(true);
        options.addArguments("user-data-dir=C:\\Users\\radwa\\AppData\\Local\\Temp\\scoped_dir11128_1157923901");
        options.addArguments("profile-directory=Profile 1");
        return options;
    }

       public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
