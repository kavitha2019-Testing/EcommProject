package Com.Mystore.PageObjects;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage  extends BaseClass {
    @FindBy(xpath="//span[text()='Proceed to checkout']")
    WebElement proceedTocheckout;

    public AddressPage(){
            PageFactory.initElements(getDriver(),this);
            }
       public ShippingPage clickoncheckout()  {
           JavascriptExecutor js = ((JavascriptExecutor)getDriver());
           js.executeScript("arguments[0].click();", proceedTocheckout);
          // Action.click(driver,proceedTocheckout);
           return new ShippingPage();
       }
}
