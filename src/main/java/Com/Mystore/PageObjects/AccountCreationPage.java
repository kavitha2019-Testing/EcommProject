package Com.Mystore.PageObjects;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage  extends BaseClass {

//    @FindBy(xpath="//form[@id='account-creation_form']//div//div//label//div//span//input[@id='id_gender1']")
//    WebElement formtitle;

    @FindBy(xpath="//h1[text()='Create an account']")
    WebElement formtitle;


     public AccountCreationPage(){
         PageFactory.initElements(getDriver(),this);
     }
     public boolean validateAccountcreatepage()
     {
        return  Action.isDisplayed(getDriver(),formtitle);
     }

}
