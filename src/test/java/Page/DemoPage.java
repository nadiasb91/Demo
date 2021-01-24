package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoPage {

    WebDriver driver;


    public DemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "gb_70")
    WebElement logInButton;
    @FindBy(id = "identifierId")
    WebElement emailField;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button")
    WebElement nextButton;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(xpath = "//div[@id=\"passwordNext\"]//div//button")
    WebElement passwordNext;
    @FindBy(name = "q")
    WebElement searchBox;
    @FindBy(xpath = "//div[@class=\"yuRUbf\"]//a[@href=\"https://www.youtube.com/user/Google?hl=es\"]")
    WebElement youtubeLink;
    @FindBy(xpath = "//div[@class=\"ANuIbb\"]")
    WebElement div;
    @FindBy(xpath ="//a[@href=\"https://accounts.google.com/SignOutOptions?hl=es&continue=https://www.google.com/\"]" )
    WebElement account;

    public void OpenBrowser(String url) {
        driver.get(url);
        //  driver.manage().window().fullscreen();

    }

    public void loginGoogle(String email, String password) {
        logInButton.click();
        emailField.sendKeys(email);
        nextButton.click();
        waitUntilVisibilityOf(passwordField);
        passwordField.sendKeys(password);
        Actions action= new Actions(driver);
       // if (passwordNext.isEnabled())
        action.moveToElement(passwordNext).click().perform();
        waitUntilVisibilityOf(account);


    }


    public void search(String criteria) {
        searchBox.sendKeys(criteria);
        searchBox.submit();
        waitUntilVisibilityOf(youtubeLink);
        youtubeLink.click();
    }


    public void waitUntilVisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilInvisibilityOf(WebElement element) {
      // WebDriverWait wait = new WebDriverWait(driver, 1);
        //wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
