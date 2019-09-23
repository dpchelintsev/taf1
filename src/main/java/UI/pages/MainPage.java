package UI.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import UI.test_base.BasePage;

public class MainPage extends BasePage {

    @FindBy(xpath = ".//a[@aria-label='Amazon']")
    public WebElement labelAmazon;

    @FindBy(xpath = ".//span[@class='nav-line-2 ' and text()='Account & Lists']")
    public WebElement accountAndListsButton;

    @FindBy(xpath = ".//input[@id='twotabsearchtextbox']")
    public WebElement searchInput;

    @FindBy(xpath = "//input[@value='Go']")
    public WebElement searchButton;

    public void clickOnSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void enterValueForSearch(String value) {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(value);
    }

    public void clickOnAccountAndListsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(accountAndListsButton));
        accountAndListsButton.click();
    }
}
