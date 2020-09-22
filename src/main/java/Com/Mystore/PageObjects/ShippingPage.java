package Com.Mystore.PageObjects;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage  extends BaseClass {

    @FindBy(id="cgv")
    WebElement terms;

    @FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
  WebElement proceedTocheckoutBtn;

    public ShippingPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void checkTheTerms(){
        Action.click(getDriver(),terms);
    }
    public PaymentPage clickonproceedTocheckout(){
        Action.click(getDriver(),proceedTocheckoutBtn);
        return new PaymentPage();
    }
}
