package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PageBase {
    protected WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver = driver;}
    public void waitForElementToBeDisplayed(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }
    public void waitForElementToBeClickable(By elementBy){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }
    public void waitForAlertToBeDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until((ExpectedConditions.alertIsPresent()));
    }
    public void clickOnElement(WebElement element, By elementBy){
        waitForElementToBeDisplayed(elementBy);
        element.click();
    }
    public void clickOnRadioButton(WebElement element, By elementBy){
        waitForElementToBeClickable(elementBy);
        element.click();
    }
    public void typeInField(WebElement element, By elementBy, String value){
        waitForElementToBeDisplayed(elementBy);
        element.sendKeys(value);
    }
    public String getElementText(WebElement element,By elementBy){
        waitForElementToBeDisplayed(elementBy);
        return element.getText();
    }
    public void clearFieldText(WebElement element, By elementBy)
    {
        waitForElementToBeDisplayed(elementBy);
        //element.clear();
        element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

    }

    // Select element from auto suggestive dropdown list
    public void selectAutoSuggestiveResult(By locator,String location){
        waitForElementToBeDisplayed(locator);
        List<WebElement> options =driver.findElements(locator);
        for(WebElement option: options)
        {
            System.out.println(option.getText());
            //options.get(2).click();
            if(option.getText().equalsIgnoreCase(location))
            {
                option.click();
                //break;
            }
            else{
                System.out.println("no country with the name: " + location + " is found");
            }
        }
    }

    public void selectStaticElementFromList(By locator, String value){
        waitForElementToBeDisplayed(locator);
        WebElement element = driver.findElement(locator);
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(value);

    }
}
