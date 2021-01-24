package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {

    WebDriver driver;

    public DemoPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "q")
    WebElement searchBox;

    public void OpenBrowser(String url){
        driver.get(url);
       // driver.manage().window().fullscreen();

    }

    public void search(String text){
        driver.manage().window().fullscreen();
        searchBox.sendKeys(text);
        searchBox.submit();

    }
}
