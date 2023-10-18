package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
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
    private By bodyContent_arBy = By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/p[1]");

    private By loginNameBy = By.cssSelector("p[class='MuiTypography-root MuiTypography-body1 css-16vw3op']");
    private By loginEmailBy = By.cssSelector("p[class='MuiTypography-root MuiTypography-body1 css-1olbkvj']");

    private By supportButton_HintBy = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[2]/div[6]/p/a");
    private By supportButton_MessageBy = By.xpath("//div/a[contains(text(), 'Join us now') and @class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-67h145']");
    private By supportButton_FooterBy = By.xpath("//div[@class='MuiBox-root css-1wrkhkf']/a[@href='https://discord.com/invite/Ve8JvD8Chq']");


    private By blinkLinkBy = By.xpath("//*[@id=\"root\"]/div[2]/div[3]/p/a[2]");
    private By jetaiLabLinkBy = By.xpath("/html/body/div[1]/div[2]/div[3]/p/a[1]");

    private By getLocationButtonBy = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-b0qesw']");
    private By locationValueBy = By.xpath("//input[@name='address']");
    private By dayLightButtonBy = By.xpath("//input[@name = 'dayLight']//..");

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

    public JetaiLabsPage clickOnJetaLabsLink() {
        WebElement jetaiLabLink = driver.findElement(jetaiLabLinkBy);
        clickOnElement(jetaiLabLink,jetaiLabLinkBy);
        return new JetaiLabsPage(driver);
    }

    public void clickOnDayLightSavingsButton(){
        WebElement dayLightRadioButton = driver.findElement(dayLightButtonBy);
        clickOnElement(dayLightRadioButton,dayLightButtonBy);
    }


}

