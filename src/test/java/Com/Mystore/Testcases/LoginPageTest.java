package Com.Mystore.Testcases;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import Com.Mystore.DataProvider.Dataprovider1;
import Com.Mystore.PageObjects.HomePage;
import Com.Mystore.PageObjects.IndexPage;
import Com.Mystore.PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.util.concurrent.TimeUnit;

public class LoginPageTest extends BaseClass {
    IndexPage IP ;
    LoginPage LP ;
    HomePage HP;
    Dataprovider1 DP =new Dataprovider1();

    @BeforeMethod(groups = {"smoke","sanity","Regression"})
    public void setup() throws InterruptedException {
       // launchApp();
       // LP= IP.clickonsignIn();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver.set(new ChromeDriver());
        getDriver().get("http://automationpractice.com/index.php?");
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.MILLISECONDS);
        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);

    }
   @Test(dataProvider = "credentials" , dataProviderClass = Dataprovider1.class)
    //@Test(groups = {"sanity","smoke"})
  public void clicklogin(String uname,String pwd) throws InterruptedException {
  // public void clicklogin() throws InterruptedException {
        IP = new IndexPage();
        LP= IP.clickonsignIn();
      // HP= LP.login(prop.getProperty("username"),prop.getProperty("password"));
        HP =LP.login(uname,pwd);
        Thread.sleep(7000);
       String actual = HP.getcurrenturl();
       String expected = "http://automationpractice.com/index.php?controller=authentication";
       //  http://automationpractice.com/index.php?controller=my-account   above url and this url both are same
        Assert.assertEquals(actual,expected);
    }

    @AfterMethod(groups = {"smoke","sanity","Regression"})
    public void teardown(){
        getDriver().close();
    }

}
