package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

public class CalendarPage extends PageBase {
    WebDriver driver;

    public CalendarPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


}
