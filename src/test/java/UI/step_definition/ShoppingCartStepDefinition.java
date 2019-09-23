package UI.step_definition;

import cucumber.api.java.en.Then;
import UI.pages.ShoppingCartPage;

import static org.testng.Assert.assertTrue;

public class ShoppingCartStepDefinition {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Then("^I see \"([^\"]*)\" in cart$")
    public void iSeeInCart(String name) {
        assertTrue(shoppingCartPage.getElementFromCartName().contains(name));
    }
}
