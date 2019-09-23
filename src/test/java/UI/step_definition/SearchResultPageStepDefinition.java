package UI.step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import UI.pages.SearchResultPage;

public class SearchResultPageStepDefinition {
    SearchResultPage searchResultPage = new SearchResultPage();

    @When("^I see list of result$")
    public void iSeeListOfResult() {
        searchResultPage.searchResults.get(0).isDisplayed();
    }

    @And("^I select first result$")
    public void iSelectFirstResult() {
        searchResultPage.selectFirstSearchResult();
    }

    @Then("^I click on 'Add to cart' button$")
    public void iClickOnAddToCartButton() {
        searchResultPage.clickOnAddToCartButton();
    }


    @And("^I click on 'View cart' button$")
    public void iClickOnViewCartButton() {
        searchResultPage.clickOnViewCartButton();
    }
}
