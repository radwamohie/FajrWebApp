package Pages;

import org.openqa.selenium.*;
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

     //  element.click();
        JavascriptExecutor executor =(JavascriptExecutor)driver;
        (executor).executeScript("arguments[0].click()",element);

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


    public void checkElement(WebElement element,By elementBy){
        try {
        waitVisibilityOf(elementBy);
     boolean isSelected = element.isSelected();
        if(isSelected == false) {
            element.click();
        }} catch (TimeoutException e) {
            throw new RuntimeException(e);
        }// element.click();
    }



}
