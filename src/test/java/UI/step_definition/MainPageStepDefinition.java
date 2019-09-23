package UI.step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.testng.Assert;
import UI.pages.MainPage;

public class MainPageStepDefinition {

    MainPage mainPage = new MainPage();

    @Given("^I'm on main page$")
    public void iMOnMainPage() {
      Assert.assertTrue(mainPage.labelAmazon.isDisplayed());
    }

    @And("^I click on Account and Lists button$")
    public void iClickOnAccountAndListsButton() {
        mainPage.clickOnAccountAndListsButton();
    }

    @And("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String value) {
        mainPage.enterValueForSearch(value);
        mainPage.clickOnSearchButton();
    }
}
