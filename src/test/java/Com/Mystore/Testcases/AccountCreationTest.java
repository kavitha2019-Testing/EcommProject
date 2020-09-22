package Com.Mystore.Testcases;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import Com.Mystore.PageObjects.AccountCreationPage;
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

public class AccountCreationTest  extends BaseClass {
    IndexPage IP;
    LoginPage LP;
   // HomePage HP;
    AccountCreationPage ACP;

    @BeforeMethod(groups = {"smoke","sanity","Regression"})
    public void setup() throws InterruptedException {
       // launchApp();
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
        // driver.get(prop.getProperty("url"));
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        Action.implicitWait(getDriver(),50);
        Action.pageLoadTimeOut(getDriver(),50);
    }
    @Test(groups = "sanity")
    public void verifyAccountCreation() throws InterruptedException {
        IP = new IndexPage();
        LP = IP.clickonsignIn();
        ACP = LP.CreateAccount(prop.getProperty("username1"));
       boolean b2= ACP.validateAccountcreatepage();
        Assert.assertTrue(b2);
       String Htitle= getDriver().getCurrentUrl();
        System.out.println("AccountCreationPage Title is:"+ Htitle);
        // http://automationpractice.com/index.php?controller=authentication&back=my-account
    }
    @AfterMethod(groups = {"smoke","sanity","Regression"})
    public void teardown() {
        getDriver().close();
    }
}