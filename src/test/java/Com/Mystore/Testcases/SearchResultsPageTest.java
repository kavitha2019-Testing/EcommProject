package Com.Mystore.Testcases;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import Com.Mystore.PageObjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchResultsPageTest  extends BaseClass {
    IndexPage IP;
    LoginPage LP;
     HomePage HP;
    AccountCreationPage AP;
    SearchResultPage  SP;

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
    @Test(groups = "smoke")
    public void verifysearchResukts(){
        IP = new IndexPage();
        SP = IP.SearchProduct("T shirts");
        boolean b3 = SP.IsProductAvailable();
        Assert.assertTrue(b3);

    }
    @AfterMethod(groups = {"smoke","sanity","Regression"})
    public void teardown() {
        getDriver().close();
    }
}
