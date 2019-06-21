package StepDefs;

import PageObjects.PetitionPage;
import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Petert on 6/12/19.
 */
public class PetitionSteps extends BaseStep {

    @Inject
    private PetitionPage petitionPage;

    @Given("^I am on petition page in admin panel$")
    public void i_am_on_petition_page_in_admin_panel() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        petitionPage.goToPetitionPage();
    }

    @When("^I click on Add new petition button$")
    public void i_click_on_Add_new_petition_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        petitionPage.clickOnAddPetitionButton();
    }

    @When("^I fill in user name as \"([^\"]*)\"$")
    public void i_fill_in_user_name_as(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        petitionPage.fillInUser(arg1);
    }

    @When("^I click on Viznachiti Zayavnika button$")
    public void i_click_on_Viznachiti_Zayavnika_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        petitionPage.clickOnViznachitiButton();
    }

    @When("^I fill in petition zagolovok with randomly generated one$")
    public void i_fill_in_petition_zagolovok_with_randomly_generated_one() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        petitionPage.fillInZagolovok();
    }

    @When("^I set a petetion category to \"([^\"]*)\"$")
    public void i_set_a_petetion_category_to(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        petitionPage.selectPetitionType(arg1);
    }

    @When("^I fill in petition text as \"([^\"]*)\"$")
    public void i_fill_in_petition_text_as(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        petitionPage.fillPetitionText(arg1);
    }

    @When("^I click on STVORITI button$")
    public void i_click_on_STVORITI_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        petitionPage.clickOnStrvoritiButton();
    }

    @Then("^I see an added petition in the petition list$")
    public void i_see_an_added_petition_in_the_petition_list() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        petitionPage.assertAddedPetitionIsPresent();
    }
}
