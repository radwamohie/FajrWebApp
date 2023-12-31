package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class CalendarPage extends BasePage {
    public ChromeDriver driver;

    public CalendarPage(ChromeDriver driver) {
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

    private By getLocationButtonBy = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-b0qesw']//span[@class='MuiTouchRipple-root css-w0pj6f']");
    private By locationValueBy = By.xpath("//input[@name='address']");

    private By dayLightCheckBoxBy = By.xpath("//input[@name='dayLight']//..");

    private By prayerCalenderButtonBy = By.xpath("//div[@class='MuiBox-root css-79elbk']//span[@class='MuiTouchRipple-root css-w0pj6f']");
    private By prayerTimesAddingAutoBy =By.xpath("//button[contains(text(),'Integrate Automatically (recommended)')]/span[@class='MuiTouchRipple-root css-w0pj6f']");
    private By googleConnectBy = By.xpath("//p[contains(text(),'Connect your Calendar')]");
    private By calendarCreationMeassageBy= By.xpath("//div[@class='MuiBox-root css-j8ms94']//p[contains(text(),'Your calendar has been updated successfully')]");
   private By unSyncBy=By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-15h3fus']");
    private By removeCalendarBy = By.xpath("//button[contains(text(),'Remove from your calendar')]");
    private By unSyncCalendarBy =By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-nj1j04']/span[@class='MuiTouchRipple-root css-w0pj6f']");
    private By fajrTimeBy=By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-vnnzou']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-spacing-xs-1 MuiGrid-grid-xs-4 css-jni0n4'][1]/div[@class='MuiBox-root css-1akavnz']/div[@class='MuiBox-root css-l6ldvr']");

    private By fajrSettingBy = By.xpath("//input[@name='fajr']//..");
    private By sunriseSettingBy = By.xpath("//input[@name='sunrise']//..");
    private By dhuhrSettingBy = By.xpath("//input[@name='dhuhr']//..");
    private By asrSettingBy = By.xpath("//input[@name='asr']//..");
    private By maghribSettingBy = By.xpath("//input[@name='maghrib']//..");
    private By ishaSettingBy = By.xpath("//input[@name='isha']//..");
    private By ishaStartTimeBy = By.xpath("//input[@name='ishaStart']");
    private By ishaDurationBy = By.xpath("//input[@name='ishaDuration']");



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
    public void enterCity(String city) {
        WebElement locationValue = driver.findElement(locationValueBy);
        setElement(locationValue, locationValueBy,city);
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
    public void addingPrayerTimesAddingAuto(){
        WebElement prayerAuto =driver.findElement(prayerTimesAddingAutoBy);
        System.out.println(prayerAuto.getText());
        clickOnElement(prayerAuto,prayerTimesAddingAutoBy);
    }
    public void connectToGoogle(){
        WebElement googleConnect =driver.findElement(googleConnectBy);
        System.out.println(googleConnect.getText());
        clickOnElement(googleConnect,googleConnectBy);
    }


    public String getCalendarCreationMessage(){
        WebElement calendarCreationMessage = driver.findElement(calendarCreationMeassageBy);
        System.out.println(calendarCreationMessage.getText());
        return getElementText(calendarCreationMessage,calendarCreationMeassageBy);
    }

    public void setLocation(double latitude,double longitude,double accuracy){
     Map<String,Object> coordinates = new HashMap<>();
        coordinates.put("latitude",latitude);
        coordinates.put("longitude",longitude);
        coordinates.put("accuracy",accuracy);
       //Map coordinates =Map.of("latitude",latitude,"longitude",longitude,"accuracy",accuracy);
        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
       // driver.get("https://stg-calendar.fajrapp.com/");
    }
    public void scrollToPageBottom(){
        JavascriptExecutor js  = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void ClickOnRemoveCalendar(){
        WebElement removeCalendarButton =driver.findElement(removeCalendarBy);
        System.out.println(removeCalendarButton.getText());
        clickOnElement(removeCalendarButton, removeCalendarBy);
    }
    public int getCheckRemoveCalendarButton(){
        WebElement unSyncButton =driver.findElement(unSyncBy);
        System.out.println(unSyncButton.getText());
       return elementExists(unSyncBy);
    }
    public boolean checkRemoveCalendarButtonExist(){
        WebElement unSyncButton =driver.findElement(removeCalendarBy);
        System.out.println(unSyncButton.getText());
        return elementExist(unSyncButton,removeCalendarBy);
    }
    public void clickOnunSyncFromCalendar(){
        WebElement removeButton =driver.findElement(unSyncCalendarBy);
        System.out.println(removeButton.getText());
        clickOnElement(removeButton,unSyncCalendarBy);
    }


    public String getFajrPrayerTimeAsString(){
        WebElement fajrTimeText = driver.findElement(fajrTimeBy);
       String fajrTimeAsString = getElementText(fajrTimeText,fajrTimeBy);
        return fajrTimeAsString;
    }

    //remove AM from prayer in string form and trimming it
    public String removingAMFromFajrTime(String fajrTimeAsString){
        String stringStrippedTimeElement = fajrTimeAsString.replaceAll(" AM", " ");
        String fajrTimeTrimmed = stringStrippedTimeElement.trim();
        return fajrTimeTrimmed;
    }


    //method to convert prayer in string form to time component of pattern hours and minutes
    public LocalTime parseFajrStringToTime(String fajrTimeTrimmed){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime fajrTime = LocalTime.parse(fajrTimeTrimmed,formatter);
        return fajrTime;
    }

    public Long durationBetweenPrayertimeInHours(LocalTime time1 ,LocalTime time2){
        long diffInHours = java.time.Duration.between(time1,time2).toHours();
        return diffInHours;
    }
    public String getFajrCheck(){
        WebElement fajrCheckbox = driver.findElement(fajrSettingBy);
        return getElementValue(fajrCheckbox, fajrSettingBy);
    }
    public String getSunriseCheck(){
        WebElement sunriseCheckbox = driver.findElement(sunriseSettingBy);
        return getElementValue(sunriseCheckbox, sunriseSettingBy);
    }

    public String getDhuhrCheck(){
        WebElement dhuhrCheckbox = driver.findElement(dhuhrSettingBy);
        return getElementValue(dhuhrCheckbox,dhuhrSettingBy);
    }
    public String getAsrCheck(){
        WebElement asrCheckbox = driver.findElement(asrSettingBy);
        return getElementValue(asrCheckbox,asrSettingBy);
    }
    public String getMaghribCheck(){
        WebElement maghribCheckbox = driver.findElement(maghribSettingBy);
        return getElementValue(maghribCheckbox,maghribSettingBy);
    }

    public String getIshaaCheck(){
        WebElement ishaCheckbox = driver.findElement(ishaSettingBy);
        return getElementValue(ishaCheckbox,ishaSettingBy);
    }
    public void clickOnIshaaCheckbox(){
        WebElement ishaCheckbox = driver.findElement(ishaSettingBy);
        clickOnElement(ishaCheckbox,ishaSettingBy);
    }
    public void setIshaaStart(String startValue){
        WebElement ishaStartTime = driver.findElement(ishaStartTimeBy);
        setElement(ishaStartTime,ishaStartTimeBy,startValue);
    }
    public void setIshaaDuration(String duration){
        WebElement ishaDuration = driver.findElement(ishaDurationBy);
        setElement(ishaDuration,ishaDurationBy,duration);
    }
    public String getIshaaStart(){
        WebElement ishaStartTime = driver.findElement(ishaStartTimeBy);
        return getElementText(ishaStartTime,ishaStartTimeBy);
    }
    public String getIshaaDuration(){
        WebElement ishaDuration = driver.findElement(ishaDurationBy);
        return getElementText(ishaDuration,ishaDurationBy);
    }




}