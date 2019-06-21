package StepDefs;

import PageObjects.AdminMainPage;
import PageObjects.LoginPage;
import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by Petert on 5/5/19.
 */
public class LoginSteps extends BaseStep {
    @Inject
    private LoginPage loginPage;
    @Inject
    private AdminMainPage adminMainPage;

    @Given("^I am successfully logged in admin panel$")
    public void i_am_successfully_logged_in_admin_panel() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.successfulLogin();
    }

    @Then("^I am on the Admin page on URL \"([^\"]*)\"$")
    public void i_am_on_the_Admin_page_on_URL(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        adminMainPage.checkNewsButtonIsDisplayed();
    }
}
