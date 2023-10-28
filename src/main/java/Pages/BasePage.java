package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class BasePage {
    public ChromiumDriver driver;

    public BasePage(ChromiumDriver driver) {
        this.driver = driver;
    }

    public void waitForAlertToBeDisplayed() {
        WebDriverWait explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWaitByElement.until(ExpectedConditions.alertIsPresent());
    }


    public void waitVisibilityOf(By elementBy) {
        WebDriverWait explicitWaitByElement = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWaitByElement.until(ExpectedConditions.visibilityOfElementLocated(elementBy));

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
        //element.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        (executor).executeScript("arguments[0].click()", element);
    }
}