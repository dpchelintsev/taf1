package UI.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import UI.test_base.BasePage;

public class SignInPage extends BasePage {

    @FindBy(xpath = ".//h1[contains(text(),'Sign in')]")
    public WebElement signInLabel;

    @FindBy(xpath = ".//a[@id='createAccountSubmit']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    public WebElement signInButton;

    public void clickOnCreateAccountButton(){
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        createAccountButton.click();
    }

    public void clickOnSignInButton(){
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void signIn(String email, String password)  {
        enterEmail(email);
        enterPassword(password);
        clickOnSignInButton();
    }
}
