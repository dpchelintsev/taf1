package UI.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import UI.test_base.BasePage;
import UI.utils.Consts;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = ".//input[@id='continue']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='ap_password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    public WebElement reEnterPasswordInput;

    @FindBy(xpath = "//input[contains(@class,'input-code')]")
    public WebElement codeFromEmailInput;

    @FindBy(xpath = "//input//following-sibling::span[contains(text(),'Verify')]")
    public WebElement verifyButton;

    public void clickOnCreateAccountButton(){
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        createAccountButton.click();
    }

    public void clickOnVerifyButton(){
        wait.until(ExpectedConditions.elementToBeClickable(verifyButton));
        verifyButton.click();
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void reEnterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(reEnterPasswordInput));
        reEnterPasswordInput.sendKeys(password);
    }

    public void enterCodeFromEmail(String code) {
        wait.until(ExpectedConditions.visibilityOf(codeFromEmailInput));
        nameInput.sendKeys(code);
    }

    public void createAccount(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        reEnterPassword(password);
        clickOnCreateAccountButton();
        String code = getCodeFromEmail(Consts.AMAZON_EMAIL, Consts.AMAZON_PASSWORD);
        enterCodeFromEmail(code);
        clickOnVerifyButton();
    }
}
