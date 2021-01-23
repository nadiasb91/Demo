package Test;

import Page.DemoPage;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class DemoTest {

    WebDriver driver;
    DemoPage page;

    @BeforeSuite
    public void init() {
        WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new FirefoxDriver();
        page= new DemoPage(driver);
        page.OpenBrowser("https://google.com");
    }

    @Test
    public void validateTitle() {
        Assert.assertEquals("Google",driver.getTitle());
    }

    @Test
    public void search(){
        page.search("selenium");
    }

   /* @AfterSuite
    public void close(){
        driver.close();
    }*/


}
