package Com.Mystore.Testcases;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import Com.Mystore.PageObjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EndToEndTest  extends BaseClass {
    IndexPage IP;
    LoginPage LP;
    HomePage HP;
    AccountCreationPage ACP;
    SearchResultPage SP;
    AddToCartPage ATCP;
    OrderPage OP;
    AddressPage AP;
    ShippingPage SHP;
    PaymentPage PP;
    OrederSummary OS;
    OrderConfirmationPage OCP;

    @Parameters ("browser1")
 @BeforeMethod(groups = {"smoke","sanity","Regression"})
   // @BeforeMethod
     public void setup( String browsername) throws InterruptedException {
       // public void setup()throws InterruptedException  {
        logger.info("********************************browser launching***************");
      // launchApp();
        if (browsername.equals("Chrome")) {
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
            Action.implicitWait(getDriver(), 50);
            Action.pageLoadTimeOut(getDriver(), 50);
        } else if (browsername.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            //  driver = new FirefoxDriver(options);
           //  Set Browser to ThreadLocalMap
            driver.set(new FirefoxDriver());
            getDriver().manage().window().maximize();
            getDriver().manage().deleteAllCookies();
            getDriver().get("http://automationpractice.com/index.php?");
            Action.implicitWait(getDriver(), 50);
            Action.pageLoadTimeOut(getDriver(), 50);
        } else if (browsername.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
//            options.addArguments("enable-automation");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-infobars");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--disable-browser-side-navigation");
//            options.addArguments("--disable-gpu");
            driver = new ThreadLocal<RemoteWebDriver>();
            // Set Browser to ThreadLocalMap
            driver.set(new InternetExplorerDriver());
            getDriver().manage().window().maximize();
            getDriver().manage().deleteAllCookies();
            getDriver().get("http://automationpractice.com/index.php?");
            Action.implicitWait(getDriver(), 50);
            Action.pageLoadTimeOut(getDriver(), 50);
        }
    }
   @Test(groups = "Regression")
    //@Test()
    public void verifyTotalprice() throws Exception {
        IP = new IndexPage();
      logger.info("************************Searching for products***************");
        SP = IP.SearchProduct("T shirts");
        ATCP = SP.clickonProduct();
        ATCP.Enterquantity("2");
        ATCP.SelectSize("M");
        ATCP.clickAddToCart();
        OP = ATCP.clickoncheckout();
        LP = OP.clickoncheckout();
        AP = LP.login1("kavitha_abburi@yahoo.com","yuvansai1");
        SHP = AP.clickoncheckout();
        SHP.checkTheTerms();
       PP= SHP.clickonproceedTocheckout();
      OS =  PP.clickonPaymentMethod();
        OCP = OS.clickOnConformBtn();
     String actualmsg = OCP.validateconfirmMessage();
        Assert.assertEquals(actualmsg,"Your order on My Store is complete.");
    }
        @AfterMethod(groups = {"smoke","sanity","Regression"})
       // @AfterMethod()
        public void teardown() { getDriver().close();
        }
    }

