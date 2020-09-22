package Com.Mystore.PageObjects;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage  extends BaseClass {

     @FindBy(xpath = "//span[@class='lighter']")   // Dresses
    WebElement searchproduct;

      @FindBy(xpath="//select[@id='selectProductSort']")
      WebElement sortprice;               // sorting dresses from low to high

 @FindBy(xpath = "//span[@text(),'T shirts']")
    WebElement searchproductTshirt;

     @FindBy(xpath = "//img[@class='replace-2x img-responsive']")
     WebElement productresultforTshirts;

     public SearchResultPage(){
         PageFactory.initElements(getDriver(),this);
     }
//     public boolean SearchProductDisplay(){
//        return Action.isDisplayed(driver,searchproduct);    // dresses search product
//     }
      public boolean IsProductAvailable(){
         return Action.isDisplayed(getDriver(),productresultforTshirts);
      }

      public AddToCartPage clickonProduct(){
         Action.click(getDriver(),productresultforTshirts);
         return new AddToCartPage();
      }
}
