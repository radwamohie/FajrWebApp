package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver=driver;
    }

    public  void waitForAlertToBeDisplayed() {
        WebDriverWait explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWaitByElement.until(ExpectedConditions.alertIsPresent());
    }

    public  void waitVisibilityOf(By elementBy) {
        WebDriverWait explicitWaitByElement = new WebDriverWait(driver,Duration.ofSeconds(10));
        explicitWaitByElement.until(ExpectedConditions.visibilityOfElementLocated(elementBy));

    }
    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public void clickOnElement(By elementBy){
        driver.findElement(elementBy).click();
    }

    public String getElementText(By elementBy){
        return driver.findElement(elementBy).getText();
    }

    public void setElement(By elementBy ,String value){
       driver.findElement(elementBy).sendKeys(value);
    }

}
