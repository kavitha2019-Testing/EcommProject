package Com.Mystore.PageObjects;

import Com.Mystore.ActionDriver.Action;
import Com.Mystore.BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {

    @FindBy(xpath = "//td[@class='cart_unit']/span/span")
    WebElement unitprice;
    @FindBy(id = "total_price")
    WebElement totalprice;
    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    WebElement proceedTocheckout;

    public OrderPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public double getUnitPrice() {
        String unitprice1 = unitprice.getText();
        String unit = unitprice1.replaceAll("[^a-zA-Z0-9]", "");
        double finalunitprice = Double.parseDouble(unit);
        return finalunitprice / 100;
    }

    public double getTotalPrice() {
        String totalprice1 = totalprice.getText();
        String tot = totalprice1.replaceAll("[^a-zA-Z0-9]", "");
        double finaltotalprice = Double.parseDouble(tot);
        return finaltotalprice / 100;
    }
    public LoginPage clickoncheckout(){
        Action.click(getDriver(),proceedTocheckout);
        return  new LoginPage();
    }
}



