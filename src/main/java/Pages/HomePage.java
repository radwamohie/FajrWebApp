package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageBase;

public class HomePage extends PageBase {
    public WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public By addressFieldBy = By.xpath("//input[@name='address']");
    public By locationDropdownlistBy = By.className("pac-container");
    public By calculationMethodBy = By.id("mui-component-select-calculationMethod");
    String calcMethodValue;
    By calculationOptionBy = By.xpath("//span[text() = '"+ calcMethodValue + "']");
    //By dayLightButtonBy = By.xpath("//span//input[@name= \"dayLight\"]");
    By dayLightButtonBy = By.className("dayLightButtonBy");


    public By linkedin_icon = By.cssSelector("button[aria-label='linkedin']");
    public By facebook_icon = By.cssSelector("button[aria-label='facebook']");
    public By twitter_icon = By.cssSelector("button[aria-label='twitter']");
    public By whatsapp_icon = By.cssSelector("button[aria-label='whatsapp']");
    public By productHunt_icon = By.cssSelector("a[class='productHuntLink']]");

    public By arabic_icon =By.xpath("//*[@id=\"root\"]/div[2]/div[1]/nav/div/div[3]/div/div/button[2]");
    public By headerTitle_ar =By.cssSelector("p[class='MuiTypography-root MuiTypography-body1 socialLinksContent css-9l3uo3']");
    public By BodyContent_ar =By.cssSelector("p[class='MuiTypography-root MuiTypography-body1 css-bz273z']");

    public By loginName= By.cssSelector("p[class='MuiTypography-root MuiTypography-body1 css-16vw3op']");
    public By loginEmail= By.cssSelector("p[class='MuiTypography-root MuiTypography-body1 css-1olbkvj']");

    public By SupportButton_Hint = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[2]/div[6]/p/a");
    public By SupportButton_SuppotMessage = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[4]/div[2]/a");
    public By SupportButton_Footer = By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div[1]/a");




    public String getLoginEmail(){
        return driver.findElement(loginEmail).getText();
    }

    public String getLoginName(){
        return driver.findElement(loginName).getText();
    }

    public void clickOnLinkedinIcon(){
        driver.findElement(linkedin_icon).click();
    }
    public void clickOnWhatsappIcon(){
        driver.findElement(whatsapp_icon).click();
    }
    public void clickOnFacebookIcon(){
        driver.findElement(facebook_icon).click();
    }
    public void clickOnTwitterIcon(){
        driver.findElement(twitter_icon).click();
    }
    public void clickOnProductHuntIcon(){
        driver.findElement(productHunt_icon).click();
    }
    public void switchToArabicLang(){
        driver.findElement(arabic_icon).click();
    }
    public String getArabicHeaderTitle(){
        return driver.findElement(headerTitle_ar).getText();
    }

    public String getArabicBodyContent(){
        return driver.findElement(BodyContent_ar).getText();
    }

    public void clickSupportFromHintMessage(){
        driver.findElement(SupportButton_Hint).click();
    }

    public void clickSupportFromSupportMessage(){
        driver.findElement(SupportButton_SuppotMessage).click();
    }




    public void enterAddress(String country){
        WebElement addressField = driver.findElement(addressFieldBy);
        typeInField(addressField,addressFieldBy,country);
    }
    public void clearAddressField(){
        WebElement addressField = driver.findElement(addressFieldBy);
        clearFieldText(addressField,addressFieldBy);
    }
    public void selectCountry(String country){
        selectAutoSuggestiveResult(locationDropdownlistBy,country);
    }
    public void setCalcMethodBy(String value){
        calcMethodValue = value;
        calculationOptionBy = By.xpath("//span[text() = '"+ calcMethodValue + "']");
    }
    public void selectCalculationMethod(String value){
        WebElement calculationMethodDropDown = driver.findElement(calculationMethodBy);
        clickOnElement(calculationMethodDropDown, calculationMethodBy);
        setCalcMethodBy(value);
        WebElement calculationOption = driver.findElement(calculationOptionBy);
        clickOnElement(calculationOption, calculationOptionBy);

    }
    public void clickDayLightRadioButton(){
        WebElement dayLightRadioButton = driver.findElement(dayLightButtonBy);
        clickOnElement(dayLightRadioButton,dayLightButtonBy);
    }







}
