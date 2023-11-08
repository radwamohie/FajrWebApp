package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;


public class BasePage {
    public ChromeDriver driver;

    public BasePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void waitForAlertToBeDisplayed() {
        WebDriverWait explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWaitByElement.until(ExpectedConditions.alertIsPresent());
    }
    public void waitVisibilityOf(By elementBy) {
        WebDriverWait explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWaitByElement.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        //visibilityOfElementLocated(elementBy)
    }

    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public String getElementText(WebElement element, By elementBy) {
        waitVisibilityOf(elementBy);
        return element.getText();
    }

    public String getElementValue(WebElement element, By elementBy) {
        waitVisibilityOf(elementBy);
        return element.getAttribute("value");
    }
    public int elementExists(By elementBy) {
        List<WebElement> elements = driver.findElements(elementBy);
        return elements.size();
    }

    public boolean elementExist(WebElement element,By elementBy) {
        //WebDriverWait explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(10));
       /* try {
        explicitWaitByElement.until(ExpectedConditions.presenceOfElementLocated(elementBy));
            } catch (TimeoutException e) {
        System.out.println("Element does not exist");
           }*/
        waitVisibilityOf(elementBy);
     return element.isDisplayed();

    }


    public boolean checkboxSelected(WebElement element, By elementBy){
        waitVisibilityOf(elementBy);
        return element.isSelected();
    }

    public void clearElementText(WebElement element, By elementBy) {
        waitVisibilityOf(elementBy);
        element.clear();
    }

    public void setElement(WebElement element, By elementBy, String value) {
        waitVisibilityOf(elementBy);
        element.sendKeys(value);
    }


    public void performClickOnElement(WebElement element, By elementBy) {
        waitVisibilityOf(elementBy);
        new Actions(driver).click(element).perform();
    }

    public void clickOnElement(WebElement element, By elementBy) {
        waitVisibilityOf(elementBy);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        (executor).executeScript("arguments[0].click()", element);
    }


}