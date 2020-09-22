package Com.Mystore.PageObjects;

import Com.Mystore.BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {

    @FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
    WebElement confirmMessage;

    public OrderConfirmationPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public String  validateconfirmMessage(){
        String confirmMsg =  confirmMessage.getText();
        return confirmMsg;
    }
}
