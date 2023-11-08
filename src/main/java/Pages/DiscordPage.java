package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DiscordPage extends BasePage{

    private ChromiumDriver driver;
    private By fajrAppLabelBy = By.xpath("//h1[@class='heading-xl-semibold-3E1dYv defaultColor-1GKx81 title-3FQ39e title-10kb1R']");

    public DiscordPage (ChromeDriver driver){
        super(driver);
        this.driver=driver;
    }

    public String getFajrAppLabel (){
        WebElement fajrLabel = driver.findElement(fajrAppLabelBy);
        System.out.println(fajrLabel);
        return getElementText(fajrLabel,fajrAppLabelBy);
    }


}
