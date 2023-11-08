package base;

import Pages.CalendarPage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Driver;
import java.util.Optional;

import org.openqa.selenium.devtools.DevTools;

public class BaseTests {
    private ChromeDriver driver;
    protected CalendarPage calendarPage;
    protected DevTools devtools;

   @BeforeClass
    public void SetUp(){
       System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver=new ChromeDriver(getChromeOptions());
        DevTools  devtools = driver.getDevTools();
        devtools.createSession();
        goHome();
           }
   /* @BeforeClass
   public void SetUpFireFox(){
       System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
       driver=new FirefoxDriver();
       goHome();
   }*/
    @BeforeMethod
    public void goHome(){
        driver.get("https://stg-calendar.fajrapp.com/");
        calendarPage = new CalendarPage((ChromeDriver) driver);
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

    public  void readFromSheet() throws IOException {
      //Path of the excel file
        FileInputStream fs = new FileInputStream("src/main/resources/data/EmailExamples.xlsx");
         //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows= sheet.getLastRowNum();
        int cols= sheet.getRow(1).getLastCellNum();

        for(int r=0;r<=rows;r++){
            XSSFRow row =sheet.getRow(r);
            for(int c=0;c<cols;c++){
                XSSFCell cell =row.getCell(c);

               switch (cell.getCellType()){
                   case STRING -> System.out.println(cell.getStringCellValue());
                   case NUMERIC -> System.out.println(cell.getNumericCellValue());
                   case BOOLEAN -> System.out.println(cell.getBooleanCellValue());
               }
            }
            System.out.println();
        }

}
}

