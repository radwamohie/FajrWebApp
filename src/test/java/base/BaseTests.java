package base;

import Pages.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.WindowManager;
import org.openqa.selenium.devtools.v85.fetch.Fetch;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    protected ChromeDriver driver;
    protected HomePage homePage;
    protected DevTools devtools;

    private By homeButton = By.cssSelector("img[class='MuiBox-root css-1yje24i']");

    @BeforeClass
    public void SetUp(){
        //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        devtools = driver.getDevTools();
        devtools.createSession();
        goHome();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://stg-calendar.fajrapp.com/");
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /*@AfterMethod
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
    }*/
    //@AfterClass
    public  void tearDown(){
     driver.quit();
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new  ChromeOptions();
      //  options.setHeadless(true);
        options.addArguments("user-data-dir=/tmp/.com.google.Chrome.sNyfOn/Profile 2/");
        options.addArguments("profile-directory=Profile 1");
        return options;
    }

       public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
