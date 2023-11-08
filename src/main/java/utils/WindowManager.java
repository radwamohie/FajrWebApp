package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.IOException;




public class WindowManager {

    private ChromeDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager (WebDriver driver){
        this.driver= (ChromeDriver) driver;
        navigate=driver.navigate();
    }

    public void switchToWindow(String windowTitle)
    {
        var windows = driver.getWindowHandles();
        System.out.println("Windows handles:");
        windows.forEach(System.out::println);

        for (String window : windows)
        {
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);
            System.out.println("current window : " + driver.getTitle());

            if (windowTitle.equals(driver.getTitle()))
            {
                break;
            }
        }
    }
}
