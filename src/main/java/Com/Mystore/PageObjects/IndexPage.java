package Com.Mystore.PageObjects;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage  extends BaseClass {

    @FindBy(xpath="//a[@class='login']")
    WebElement signInBtn;

     @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement  mystoreLogo;

     @FindBy(id="search_query_top")
    WebElement searchproductBox;

     @FindBy(name="submit_search")
    WebElement  searchButton;


    public IndexPage(){
         PageFactory.initElements(getDriver(),this);
     }
     public LoginPage clickonsignIn() throws InterruptedException {
         Thread.sleep(5000);
        // Action.click(getDriver(),signInBtn);
         signInBtn.click();
         return new LoginPage();
     }
     public boolean validatelogo(){
          return Action.isDisplayed(getDriver(),mystoreLogo);

     }
    public String getMystoretitle(){
       String storetitle=  getDriver().getTitle();
       return storetitle;
    }
    public SearchResultPage SearchProduct(String productname){
         Action.type(searchproductBox,productname);
         Action.click(getDriver(),searchButton);
       return  new SearchResultPage();
    }
}
