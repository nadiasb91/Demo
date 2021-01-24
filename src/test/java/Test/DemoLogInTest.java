package Test;

import Page.DemoPage;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class DemoLogInTest {

    WebDriver driver;
    DemoPage page;

    @BeforeSuite
    public void init() {
        WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new FirefoxDriver();
        page = new DemoPage(driver);
        page.OpenBrowser("https://google.com");

    }


    @Test(priority = 0, enabled = false)
    public void validateLoginGoogle() {
        page.loginGoogle("lola.perez910607@gmail.com", "nbatista123");
        Assert.assertEquals("youtube - Buscar con Google", driver.getTitle());
    }

    @Test(priority = 1)
    public void search() {
        page.search("youtube");
        Assert.assertEquals("Google - YouTube", driver.getTitle());


    }



   /* @AfterSuite
    public void close(){
        driver.close();
    }*/


}
