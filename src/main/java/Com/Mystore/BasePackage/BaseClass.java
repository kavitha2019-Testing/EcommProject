package Com.Mystore.BasePackage;

import Com.Mystore.ActionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseClass {
    public static Properties prop;
    public Logger logger;
    // public static WebDriver driver;
    // Declare ThreadLocal Driver          for paralle testing need to write getdriver where u writing driver
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

   @BeforeSuite(groups = {"smoke", "sanity", "Regression"})
    public void beforesuit() {
        //  DOMConfigurator.configure("log4j.xml");
        logger = Logger.getLogger("MYStoreHybridFramework");// u can give any name under class(EmployeeRestAPI)
        PropertyConfigurator.configure("log4j.properties"); //added logger
        logger.setLevel(Level.DEBUG);
    }

    public static WebDriver getDriver() {
        // Get Driver from threadLocalmap
        return driver.get();
    }

    public void loadconfig() throws IOException {
        prop = new Properties();
        FileInputStream fp = new FileInputStream("C:/Users/kavitha/IdeaProjects/MyStoreHybridFramework/Configurations/config.properties");
        prop.load(fp);
    }

    public static void launchApp() throws InterruptedException {
        Thread.sleep(5000);
        String browser = prop.getProperty("Browser");
        Thread.sleep(5000);
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            // driver = new ChromeDriver(options);
            //Set Browser to ThreadLocalMap
            driver.set(new ChromeDriver());
            getDriver().get(prop.getProperty("url"));
            getDriver().manage().window().maximize();
            getDriver().manage().deleteAllCookies();
//         driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.MILLISECONDS);
//         driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
            Action.implicitWait(getDriver(), 50);
            Action.pageLoadTimeOut(getDriver(), 50);
        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            // driver = new FirefoxDriver(options);
            // Set Browser to ThreadLocalMap
            driver.set(new FirefoxDriver());
            getDriver().manage().window().maximize();
            getDriver().manage().deleteAllCookies();
            getDriver().get(prop.getProperty("url"));
            Action.implicitWait(getDriver(), 50);
            Action.pageLoadTimeOut(getDriver(), 50);
        } else if (browser.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
//         options.addArguments("enable-automation");
//         options.addArguments("--no-sandbox");
//         options.addArguments("--disable-infobars");
//         options.addArguments("--disable-dev-shm-usage");
//         options.addArguments("--disable-browser-side-navigation");
//         options.addArguments("--disable-gpu");
//         driver = new ThreadLocal<RemoteWebDriver>();
//         Set Browser to ThreadLocalMap
            driver.set(new InternetExplorerDriver());
            getDriver().manage().window().maximize();
//         getDriver().manage().deleteAllCookies();
//         getDriver().get(prop.getProperty("url"));
//         Action.implicitWait(getDriver(), 50);
//         Action.pageLoadTimeOut(getDriver(), 50);
        }
    }
}