package Com.Mystore.PageObjects;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {

    @FindBy(xpath="//a[contains(text(),'Pay by bank wire')]" )
    WebElement  bankwiremethod;
    @FindBy(xpath="//a[contains(text(),'Pay by check')]")
    WebElement payByCheckMethod;

    public  PaymentPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public OrederSummary clickonPaymentMethod() {
        Action.click(getDriver(), bankwiremethod);
        return new OrederSummary();
    }


    }

