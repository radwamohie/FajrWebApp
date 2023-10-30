package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class CalendarPage extends BasePage {
    public ChromiumDriver driver;

    public CalendarPage(ChromiumDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By linkedinBy = By.cssSelector("button[aria-label='linkedin']");
    private By facebookBy = By.cssSelector("button[aria-label='facebook']");
    private By twitterBy = By.cssSelector("button[aria-label='twitter']");
    private By whatsappBy = By.cssSelector("button[aria-label='whatsapp']");
    private By productHuntBy = By.className("productHuntLink");

    private By arabic_iconBy = By.xpath("//*[@id=\"root\"]/div[2]/div[1]/nav/div/div[3]/div/div/button[2]");
    private By headerTitle_arBy = By.xpath("/html/body/div[1]/div[1]/p");
    private By bodyContent_arBy = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1f07r8g']");

    private By loginNameBy = By.cssSelector("p[class='MuiTypography-root MuiTypography-body1 css-16vw3op']");
    private By loginEmailBy = By.cssSelector("p[class='MuiTypography-root MuiTypography-body1 css-1olbkvj']");

    private By supportButton_HintBy = By.linkText("Discord");
    private By supportButton_MessageBy = By.xpath("//a[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-67h145']");
    private By supportButton_FooterBy = By.xpath("//div[@class='MuiBox-root css-1wrkhkf']/a[@href='https://discord.com/invite/Ve8JvD8Chq']");


    private By blinkLinkBy = By.linkText("Blink22.com");
            //By.xpath("//a[@href='https://blink22.com/']");
    private By jetaiLabLinkBy =By.linkText("Jetai-labs");
                    //By.xpath("//a[@href='https://www.jetai-labs.com/']");

    private By getLocationButtonBy = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-b0qesw']");
    private By locationValueBy = By.xpath("//input[@name='address']");

    private By dayLightCheckBoxBy = By.xpath("//input[@name='dayLight']//..");

    private By prayerCalenderButtonBy = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1js7ss9']");
            //By.xpath("//div[@class='MuiBox-root css-79elbk']/button[contains(text(),'قم بإنشاء تقويم صلواتي')]");
    private By calendarCreationMeassageBy= By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1n64gtl']");

    private By unsyncFromCalendarBy= By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fo2gpo']");

    private By removeCalendarBy=By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-nj1j04']");
    private By fajrTimeBy=By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-vnnzou']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-spacing-xs-1 MuiGrid-grid-xs-4 css-jni0n4'][1]/div[@class='MuiBox-root css-1akavnz']/div[@class='MuiBox-root css-l6ldvr']");

    public String getLoginEmail() {
        WebElement loginEmail = driver.findElement(loginEmailBy);
        return getElementText(loginEmail,loginEmailBy);
    }
    public String getLoginName() {
        WebElement loginName = driver.findElement(loginNameBy);
        return getElementText(loginName,loginNameBy);
    }

    public void clickOnLinkedinIcon() {
        WebElement linkedin = driver.findElement(linkedinBy);
        clickOnElement(linkedin,linkedinBy);
    }

    public void clickOnWhatsappIcon() {
        WebElement whatsapp = driver.findElement(whatsappBy);
        clickOnElement(whatsapp,whatsappBy);
    }

    public void clickOnFacebookIcon() {
        WebElement facebook = driver.findElement(facebookBy);
        clickOnElement(facebook,facebookBy);
    }

    public void clickOnTwitterIcon() {
        WebElement twitter = driver.findElement(twitterBy);
        clickOnElement(twitter,twitterBy);
    }

    public void clickOnProductHuntIcon() {
        WebElement productHunt = driver.findElement(productHuntBy);
        clickOnElement(productHunt,productHuntBy);
    }

    public void switchToArabicLang() {
        WebElement arabicIcon = driver.findElement(arabic_iconBy);
        clickOnElement(arabicIcon,arabic_iconBy);
    }

    public void clickOnGetLocationButton() {
        WebElement locationButton = driver.findElement(getLocationButtonBy);
        clickOnElement(locationButton,getLocationButtonBy);
    }

    public void enterCity(String country) {
        WebElement locationValue = driver.findElement(locationValueBy);
        setElement(locationValue, locationValueBy,country);

    }

    public void clearLocationText() {
        WebElement locationValue = driver.findElement(locationValueBy);
        clearElementText(locationValue,locationValueBy);
    }

    public String getCurrentLocation() {
        WebElement locationValue = driver.findElement(locationValueBy);
        return getElementValue(locationValue,locationValueBy);
    }

    public String getArabicHeaderTitle() {
        WebElement headerTitle = driver.findElement(headerTitle_arBy);
        return getElementText(headerTitle,headerTitle_arBy);
    }

    public String getArabicBodyContent() {
        WebElement bodyTitle = driver.findElement(bodyContent_arBy);
        return getElementText(bodyTitle,bodyContent_arBy);
    }

    public DiscordPage clickSupportFromHintMessage() {
        WebElement supportButtonHint = driver.findElement(supportButton_HintBy);
        clickOnElement(supportButtonHint,supportButton_HintBy);
        System.out.println(supportButton_HintBy);
        return new DiscordPage(driver);
    }

    public DiscordPage clickSupportFromSupportMessage() {
        WebElement supportButtonMessage = driver.findElement(supportButton_MessageBy);
        clickOnElement(supportButtonMessage,supportButton_MessageBy);
        System.out.println(supportButtonMessage);
        return new DiscordPage(driver);
    }

    public DiscordPage clickSupportFromFooter() {
        WebElement supportButtonFooter = driver.findElement(supportButton_FooterBy);
        clickOnElement(supportButtonFooter,supportButton_FooterBy);
        System.out.println(supportButton_FooterBy);
        return new DiscordPage(driver);
    }

    public BlinkPage clickOnBlinkLink() {
        WebElement blinkLink = driver.findElement(blinkLinkBy);
        clickOnElement(blinkLink,blinkLinkBy);
        return new BlinkPage(driver);
    }

    public JetaiLabsPage clickOnJetaiLabsLink() {
        WebElement jetaiLabLink = driver.findElement(jetaiLabLinkBy);
        clickOnElement(jetaiLabLink,jetaiLabLinkBy);
        return new JetaiLabsPage(driver);
    }

    public void addDayLightSavingTime(){
        try {
            WebElement dayCheckBox = driver.findElement(dayLightCheckBoxBy);
            WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
            clickOnElement(dayCheckBox,dayLightCheckBoxBy);
        } catch (NoSuchElementException e)
        {
            System.out.println("element not found" + e.getMessage());
        }
    }

    public void createMyPrayersCalendar(){
        WebElement prayerCalendarButton =driver.findElement(prayerCalenderButtonBy);
        System.out.println(prayerCalendarButton.getText());
        clickOnElement(prayerCalendarButton,prayerCalenderButtonBy);
    }

    public String getCalendarCreationMessage(){
        WebElement calendarCreationMessage = driver.findElement(calendarCreationMeassageBy);
        System.out.println(calendarCreationMessage.getText());
        return getElementText(calendarCreationMessage,calendarCreationMeassageBy);
    }

    public void setLocation(double latitude,double longitude,double accuracy){
        Map<String, Object> coordinates = new HashMap<String, Object>();
        coordinates.put("latitude",latitude);
        coordinates.put("longitude",longitude);
        coordinates.put("accuracy",accuracy);
        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
    }
    public void scrollToPageBottom(){
        JavascriptExecutor js  = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void unSyncFromCalendar(){
        WebElement unSyncButton =driver.findElement(unsyncFromCalendarBy);
        System.out.println(unSyncButton.getText());
        clickOnElement(unSyncButton,unsyncFromCalendarBy);
    }
    public void removeCalendar(){
        WebElement removeButton =driver.findElement(removeCalendarBy);
        System.out.println(removeButton.getText());
        clickOnElement(removeButton,removeCalendarBy);
    }

    public String getFajrPrayerTimeAsString(){
        WebElement fajrTime = driver.findElement(fajrTimeBy);
        //System.out.println(fajrTime.getText());
        return getElementText(fajrTime,fajrTimeBy);
    }

    public int getFajrPrayerTime(){
        WebElement fajrTime = driver.findElement(fajrTimeBy);
        return convertelementTextToInt(fajrTime,fajrTimeBy);
    }


}