package Com.Mystore.PageObjects;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrederSummary extends BaseClass {
            @FindBy(xpath="//span[contains(text(),'I confirm my order')]")
    WebElement ConfirmOrderBtn;

    public OrederSummary() {
        PageFactory.initElements(getDriver(), this);
    }
    public OrderConfirmationPage clickOnConformBtn() throws Exception {
        Thread.sleep(2000);
        JavascriptExecutor js= ((JavascriptExecutor) getDriver());
        js.executeScript("arguments[0].click();", ConfirmOrderBtn);
       Action.implicitWait(getDriver(),20);
       return  new OrderConfirmationPage();
    }
}

