package UI.step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.testng.Assert;
import UI.pages.SignInPage;
import UI.utils.Consts;

public class SignInPageStepDefinition {

    SignInPage signInPage = new SignInPage();

    @When("^I'm on Sign In page$")
    public void iMOnSignInPage() {
        Assert.assertTrue(signInPage.signInLabel.isDisplayed());
    }

    @And("^I click on Create Account button$")
    public void iClickOnCreateAccountButton() {
        signInPage.clickOnCreateAccountButton();
    }

    @And("^I'm signing in$")
    public void iMSigningIn() {
        signInPage.signIn(Consts.AMAZON_EMAIL, Consts.AMAZON_PASSWORD);
    }
}
