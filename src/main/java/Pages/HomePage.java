package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public WebDriver driver;
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
    public By SupportButton_SupportMessage = By.cssSelector("a[class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-67h145']");
    public By SupportButton_Footer = By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div[1]/a");


    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

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

    public DiscordPage clickSupportFromHintMessage(){
       clickLink("Discord");
        return new DiscordPage(driver);
    }

    public DiscordPage clickSupportFromSupportMessage(){
        clickLink("Join us now");
         return new DiscordPage(driver);
    }

    public DiscordPage clickSupportFromFooter(){
           clickLink("Discord Support");
            return new DiscordPage(driver);
        }

}

