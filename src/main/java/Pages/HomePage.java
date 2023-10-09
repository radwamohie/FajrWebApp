package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public WebDriver driver;
    protected JavascriptExecutor js;


    private By linkedin_icon = By.cssSelector("button[aria-label='linkedin']");
    private By facebook_icon = By.cssSelector("button[aria-label='facebook']");
    private By twitter_icon = By.cssSelector("button[aria-label='twitter']");
    private By whatsapp_icon = By.cssSelector("button[aria-label='whatsapp']");
    private By productHunt_icon = By.className("productHuntLink");

    private By arabic_icon = By.xpath("//*[@id=\"root\"]/div[2]/div[1]/nav/div/div[3]/div/div/button[2]");
    private By headerTitle_ar = By.xpath("/html/body/div[1]/div[1]/p");
    private By bodyContent_ar = By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/p[1]");

    private By loginName = By.cssSelector("p[class='MuiTypography-root MuiTypography-body1 css-16vw3op']");
    private By loginEmail = By.cssSelector("p[class='MuiTypography-root MuiTypography-body1 css-1olbkvj']");

    private By supportButton_Hint = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div[2]/div[6]/p/a");
    private By supportButton_SupportMessage = By.cssSelector("a[class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-67h145']");
    private By supportButton_Footer =By.xpath("//div[@class='MuiBox-root css-1wrkhkf']/a[@href='https://discord.com/invite/Ve8JvD8Chq']");


    private By blinkLink = By.xpath("//*[@id=\"root\"]/div[2]/div[3]/p/a[2]");
    private By jetaiLabLink=By.xpath("/html/body/div[1]/div[2]/div[3]/p/a[1]");


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public String getLoginEmail(){
        return  getElementText(loginEmail);
    }

    public String getLoginName(){
        return getElementText(loginName);
    }

    public void clickOnLinkedinIcon(){
        clickOnElement(linkedin_icon);
    }
    public void clickOnWhatsappIcon(){
        clickOnElement(whatsapp_icon);
    }
    public void clickOnFacebookIcon(){
        clickOnElement(facebook_icon);
    }
    public void clickOnTwitterIcon(){
        clickOnElement(twitter_icon);
    }
    public void clickOnProductHuntIcon(){
        clickOnElement(productHunt_icon);
    }
    public void switchToArabicLang(){
        clickOnElement(arabic_icon);
    }

    public String getArabicHeaderTitle(){
        return getElementText(headerTitle_ar);
    }

    public String getArabicBodyContent(){
     return getElementText(bodyContent_ar);
    }

    public DiscordPage clickSupportFromHintMessage(){
        waitVisibilityOf(supportButton_Hint);
        System.out.println(supportButton_Hint);
        clickOnElement(supportButton_Hint);
        return new DiscordPage(driver);
    }

    public DiscordPage clickSupportFromSupportMessage(){
        waitVisibilityOf(supportButton_SupportMessage);
        System.out.println(supportButton_SupportMessage);
        clickOnElement(supportButton_SupportMessage);
         return new DiscordPage(driver);
    }

    public DiscordPage clickSupportFromFooter(){
        waitVisibilityOf(supportButton_Footer);
        System.out.println(supportButton_Footer);
        clickOnElement(supportButton_Footer);
            return new DiscordPage(driver);
        }

    public void scrollToBottom() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public BlinkPage clickOnBlinkLink(){
        clickOnElement(blinkLink);
        return new BlinkPage(driver);
    }

    public JetaiLabsPage clickOnJetaLabsLink(){
        clickOnElement(jetaiLabLink);
        return new JetaiLabsPage(driver);
    }


}

