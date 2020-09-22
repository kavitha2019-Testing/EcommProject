package Com.Mystore.Testcases;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import Com.Mystore.PageObjects.IndexPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IndexPageTest   extends BaseClass {
    IndexPage IP ;
    @BeforeMethod(groups = {"smoke","sanity","Regression"})
    public void setup() throws InterruptedException{
        //launchApp();
        logger.info("***************browser launching**********");
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
       // getDriver().get(prop.getProperty("url"));
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
//         driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.MILLISECONDS);
//         driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
        Action.implicitWait(getDriver(),50);
        Action.pageLoadTimeOut(getDriver(),50);
        IP = new IndexPage();
    }
@Test(groups = "smoke")
public void verifylogo() throws InterruptedException {
        logger.info("*******validating the logo********");
        boolean b= IP.validatelogo();
   Assert.assertTrue(b);
}
@Test(groups = "smoke")
public void verifytitle() {
 String s=  IP.getMystoretitle();
    System.out.println("Print store title is: "+ s);
    Assert.assertEquals(s,"My Store");
}
@AfterMethod(groups = {"smoke","sanity","Regression"})
    public void teardown(){
        getDriver().close();
    }
}
