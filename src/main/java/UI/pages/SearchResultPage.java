package UI.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import UI.test_base.BasePage;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'result-item')]//a[@class='a-link-normal a-text-normal']")
    public List<WebElement> searchResults;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(text(),'View Cart')]")
    public WebElement viewCartButton;

    public void selectFirstSearchResult(){
        wait.until(ExpectedConditions.elementToBeClickable(searchResults.get(0)));
        searchResults.get(0).click();
    }

    public void clickOnAddToCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public void clickOnViewCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        viewCartButton.click();
    }

}
