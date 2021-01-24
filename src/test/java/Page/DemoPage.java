package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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




    public void OpenBrowser(String url) {
        driver.get(url);
      //  driver.manage().window().fullscreen();

    }

    public void loginGoogle(String email, String password){
       logInButton.click();
       emailField.sendKeys(email);
       nextButton.click();
       this.waitUntilVisibilityOf(passwordField);
       passwordField.sendKeys(password);
       waitUntilVisibilityOf(passwordNext);
       passwordNext.click();

    }


    public void search(String criteria){
        searchBox.sendKeys(criteria);
        searchBox.submit();
    }



    public void waitUntilVisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilElementIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
