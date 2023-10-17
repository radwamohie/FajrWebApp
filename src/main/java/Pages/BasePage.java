package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BasePage {
    protected WebDriver driver;

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

    public void clickOnElement(WebElement element,By elementBy){
        waitVisibilityOf(elementBy);
        element.click();
    }

    public String getElementText(WebElement element,By elementBy){
        waitVisibilityOf(elementBy);
        return element.getText();
    }
    public String getElementValue(WebElement element,By elementBy){
        waitVisibilityOf(elementBy);
        return element.getAttribute("value");
    }

    public void clearElementText(WebElement element,By elementBy){
        waitVisibilityOf(elementBy);
        element.clear();
    }

    public void setElement(WebElement element,By elementBy ,String value){
        waitVisibilityOf(elementBy);
       element.sendKeys(value);
    }



}
