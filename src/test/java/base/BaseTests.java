package base;

import Pages.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    private By homeButton = By.cssSelector("img[class='MuiBox-root css-1yje24i']");

   @BeforeClass
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver(getChromeOptions());
        //ChromeDriverService service=new ChromeDriverService.Builder().withLogOutput(System.out).build();
       //driver=new ChromeDriver(service);
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
        homePage = new HomePage(driver);
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
