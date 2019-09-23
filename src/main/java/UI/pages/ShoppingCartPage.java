package UI.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import UI.test_base.BasePage;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//span[@class='a-list-item']/a[contains(@class,'sc-product-link')]")
    public WebElement elementFromCart;

    public String  getElementFromCartName(){
        wait.until(ExpectedConditions.visibilityOf(elementFromCart));
        return elementFromCart.getText();
    }
}
