package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiscordPage {

    private WebDriver driver;
    private By fajrAppLabel = By.cssSelector("h1[class='heading-xl-semibold-3E1dYv defaultColor-1GKx81 title-3FQ39e title-10kb1R']");

    public DiscordPage (WebDriver driver){
        this.driver=driver;
    }

    public String getFajrAppLabel (){
       return driver.findElement(fajrAppLabel).getText();
    }

}
