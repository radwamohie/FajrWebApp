package base;

import Pages.CalendarPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.devtools.DevTools;

public class BaseTests {
    private WebDriver driver;
    protected CalendarPage calendarPage;
    protected DevTools devtools;
    private By fajrCalendarLogo = By.xpath("//div[@class='MuiTypography-root MuiTypography-body1 css-3ws210']");

   @BeforeClass
    public void SetUp(){
       System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver(getChromeOptions());
        DevTools  devtools = ((ChromiumDriver)driver).getDevTools();
        devtools.createSession();
        goHome();
    }

   /* @BeforeClass
   public void SetUpFireFox(){
       System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
       driver=new FirefoxDriver();
       goHome();
   }*/

    @BeforeMethod
    public void goHome(){
        driver.get("https://stg-calendar.fajrapp.com/");
        calendarPage = new CalendarPage((ChromiumDriver) driver);
        driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot.toPath(),
                        new File("src/main/resources/screenshots/"+result.getName()+".png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
   @AfterClass
    public  void tearDown(){
     driver.quit();
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new  ChromeOptions();
     // options.setHeadless(true);
        options.addArguments("user-data-dir=C:\\Users\\radwa\\AppData\\Local\\Temp\\scoped_dir11128_1157923901");
        options.addArguments("profile-directory=Profile 1");
        return options;
    }

       public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
