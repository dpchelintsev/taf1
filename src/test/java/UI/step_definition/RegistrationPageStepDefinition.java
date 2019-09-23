package UI.step_definition;

import cucumber.api.java.en.And;
import org.apache.commons.lang3.RandomUtils;
import UI.pages.RegistrationPage;

public class RegistrationPageStepDefinition {

    RegistrationPage registrationPage = new RegistrationPage();

    private String name = "NameForRegistration";
    private String email = "dmitry.pchelintsevv+" + RandomUtils.nextInt(1, 100) +"@gmail.com";
    private String password = "testtest";


    @And("^I create new account$")
    public void iCreateNewAccount() throws Exception {
        registrationPage.createAccount(name, email, password);
    }
}
