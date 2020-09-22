package Com.Mystore.PageObjects;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage  extends BaseClass {

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement quantity;

    @FindBy(xpath = "//select[@id='group_1']")
    WebElement Size;

    @FindBy(xpath = "//span[text()='Add to cart']")
    WebElement AddToCartBtn;

    @FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
            WebElement  addToCartMessage;

    @FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
    WebElement ProceedTocheckoutBtn;

    public AddToCartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void Enterquantity(String Quantity) {
        Action.type(quantity, Quantity);
    }

    public void SelectSize(String size) {
        Action.selectByVisibleText(size, Size);
    }
    public void clickAddToCart(){
        Action.click(getDriver(),AddToCartBtn);
    }

    public boolean validateAddtocart() {
        Action.fluentWait(getDriver(),addToCartMessage,20);
        return Action.isDisplayed(getDriver(),addToCartMessage);
    }

    public OrderPage clickoncheckout() throws Exception {
        Action.fluentWait(getDriver(),ProceedTocheckoutBtn,20);
        Action.JSClick(getDriver(),ProceedTocheckoutBtn);
        return new  OrderPage();
    }
}
