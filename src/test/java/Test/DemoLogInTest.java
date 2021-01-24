package Test;

import Utils.Helper;
import Page.DemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class DemoLogInTest {

    WebDriver driver;
    DemoPage page;


    @BeforeSuite
    public void init() {
        WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new FirefoxDriver();
        page = new DemoPage(driver);
        page.OpenBrowser(Helper.url);

    }


    @Test(priority = 0)
    public void validateLoginGoogle() {
        page.loginGoogle(Helper.email,Helper.password);
        Assert.assertEquals("Google", driver.getTitle());
    }

    @Test(priority = 1)
    public void search() {
        page.search("youtube");
        Assert.assertEquals("Google - YouTube", driver.getTitle());


    }



    @AfterSuite
    public void close(){
       // driver.manage().deleteAllCookies();
       // driver.close();
    }


}
