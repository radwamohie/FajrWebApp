package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DiscordPage{

    private WebDriver driver;
    private By fajrAppLabel = By.xpath("//div[@class='container-2xOgW-']/h1[@class='heading-xl-semibold-3E1dYv defaultColor-1GKx81 title-3FQ39e title-10kb1R']");

    public DiscordPage (WebDriver driver){
        this.driver=driver;
    }

    public String getFajrAppLabel (){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(fajrAppLabel)));
        System.out.println(driver.findElement(fajrAppLabel));
        return driver.findElement(fajrAppLabel).getText();
    }


}
