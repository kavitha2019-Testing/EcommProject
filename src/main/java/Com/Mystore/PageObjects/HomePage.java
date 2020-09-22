package Com.Mystore.PageObjects;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  extends BaseClass {

  @FindBy(xpath="//span[text()='Order history and details']")
    WebElement  OrderHistory;

  @FindBy(xpath="//span[text()='My wishlists']")
    WebElement Wishlist;

  public HomePage(){
      PageFactory.initElements(getDriver(),this);
  }

  public Boolean MywishList(){
       return Action.isDisplayed(getDriver(),Wishlist);
  }
  public Boolean MyOrderhistory(){
      return Action.isDisplayed(getDriver(),OrderHistory);
  }

  public String  getcurrenturl(){
      String hometitle = getDriver().getCurrentUrl();
      return hometitle;
  }
}
