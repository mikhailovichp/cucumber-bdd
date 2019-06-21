package StepDefs;

import Config.VarVault;
import PageObjects.UsersPage;
import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by Petert on 5/10/19.
 */
public class UsersSteps extends BaseStep {

    @Inject
    private UsersPage usersPage;

    private String userInn;

    @Given("^I am on users page in admin panel$")
    public void i_am_on_users_page_in_admin_panel() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.goToUsersPage();
    }

    @Given("^I checked what is the INN that is not used$")
    public void i_checked_what_is_the_INN_that_is_not_used() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.findNotUsedINN();
    }

    @When("^I click on Add new user button$")
    public void i_click_on_Add_new_user_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.clickOnAddButton();
    }

    @When("^I Edit a user$")
    public void i_click_on_user_settings_icon() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.openEditUserPanel();
    }

    @When("^I change First name field to a random value$")
    public void i_change_First_name_field_to_a_random_value() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.fillFirstNameRandom();
    }

    @When("^I change Last name field to a random value$")
    public void i_change_Last_name_field_to_a_random_value() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.fillLastNameRandom();
    }

    @When("^I change address to a random value$")
    public void i_change_address_to_a_random_value() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.fillRandomAddress();
    }

    @When("^I fill in INN field random INN number$")
    public void i_fill_in_INN_field_random_INN_number() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.fillINN();
    }

    @When("^I fill in INN field with \"([^\"]*)\" value$")
    public void i_fill_in_INN_field_with_value(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.fillINNwithValue(arg1);
    }

    @When("^I fill in Last name field with \"([^\"]*)\"$")
    public void i_fill_in_Last_name_field_with(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.fillLastName(arg1);
    }

    @When("^I fill in Name field with \"([^\"]*)\"$")
    public void i_fill_in_Name_field_with(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.fillName(arg1);
    }

    @When("^I fill in Passport field with \"([^\"]*)\"$")
    public void i_fill_in_Passport_field_with(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.fillPassport(arg1);
    }

    @When("^I add passport photo$")
    public void i_add_passport_photo() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.addPassportPhoto();
        usersPage.addPassportPhoto();
    }

    @When("^I add inn photo$")
    public void i_add_inn_photo() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.addInnPhoto();
    }

    @When("^I add photo with passport$")
    public void i_add_photo_with_passport() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.addPhotoWithPassport();
    }

    @When("^I fill Address field$")
    public void i_fill_Address_field() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.fillAddress();
    }

    @When("^I fill in Login field with random login$")
    public void i_fill_in_Login_field_with_random_login() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.fillRandomLogin();
    }

    @When("^I fill in Password field with \"([^\"]*)\"$")
    public void i_fill_in_Password_field_with(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.fillPassword(arg1);
    }

    @When("^I click a button Zberegti$")
    public void i_click_a_button_Zberegti() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.clickOnZberegtiButton();
    }

    @When("^I click a Success button$")
    public void i_click_a_Success_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.clickOnSuccessButton();
    }

    @Then("^I see an error popup$")
    public void i_see_an_error_popup() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.assertUserWithSuchInnPopupErrorIsDisplayed();
        System.out.println("User with such inn popup error was displayed");
    }

    @Then("^I am on users page in admin panel on URL \"([^\"]*)\"$")
    public void i_am_on_users_page_in_admin_panel_on_URL(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("https://someURL/admin/users/new", arg1);
    }

    @Then("^I see a created User in a Users table$")
    public void i_see_a_created_User_in_a_Users_table() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.checkUserWithDefinedTextExists(VarVault.getInstance().getInn());
    }

    @Then("^I see a user with new FirstName and LastName$")
    public void i_see_a_user_with_new_FirstName_and_LastName() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String stringToSearch = VarVault.getInstance().getLastName() + " " + VarVault.getInstance().getFirstName();
        System.out.println(stringToSearch);
        usersPage.checkUserWithDefinedTextExists(stringToSearch);
    }

    @Then("^I see a user with new City, Street and Building$")
    public void i_see_a_user_with_new_City_Street_and_Building() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        usersPage.checkUserWithDefinedTextExists(VarVault
                .getInstance().getCity()+", "+VarVault
                .getInstance().getStreet()+", "+VarVault
                .getInstance().getBuilding()+", 35");
    }
}
