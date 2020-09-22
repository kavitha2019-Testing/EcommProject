package Com.Mystore.PageObjects;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

   @FindBy(xpath="//input[@name='email']")
    WebElement username;

   @FindBy(name="passwd")
    WebElement password;

   @FindBy(name="SubmitLogin")
    WebElement signBtn;

   @FindBy(xpath="//input[@name='email_create']")
    WebElement emailForNewAccount;

   @FindBy(xpath="//i[@class='icon-user left']")
    WebElement CreateNewAccountBtn;

    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }
  public HomePage login(String Username,String Password) throws InterruptedException {
      Action.type(username, Username);
      Action.type(password, Password);
      Action.implicitWait(getDriver(),20);
      Action.click(getDriver(),signBtn);
      return new HomePage();
  }
    public AddressPage login1(String Username,String Password){
        Action.type(username, Username);
        Action.implicitWait(getDriver(),20);
        Action.type(password, Password);
        Action.implicitWait(getDriver(),20);
        Action.click(getDriver(),signBtn);
        return new AddressPage();
    }
    public AccountCreationPage CreateAccount(String NewEmail){
        Action.type(emailForNewAccount,NewEmail);
        Action.click(getDriver(),CreateNewAccountBtn);
        return new AccountCreationPage();
  }
}
