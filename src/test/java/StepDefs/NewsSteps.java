package StepDefs;

import PageObjects.NewsPage;
import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by Petert on 5/15/19.
 */
public class NewsSteps extends BaseStep {

    @Inject
    private NewsPage newsPage;

    @Given("^I am on news page in admin panel$")
    public void i_am_on_news_page_in_admin_panel() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.goToNewsPage();
    }

    @When("^I click on Add new news button$")
    public void i_click_on_Add_new_news_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.clickOnaddNewNewsButton();
    }

    @When("^I click on the first news item in the news list$")
    public void i_click_on_the_first_news_item_in_the_news_list() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.clickOnTheFirstNewsItem();
    }

    @When("^I fill in NAZVA field with random value$")
    public void i_fill_in_NAZVA_field_with_random_value() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.setNazva();
    }

    @When("^I fill in ZAGOLOVOK field with random unique value$")
    public void i_fill_in_ZAGOLOVOK_field_with_random_unique_value() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.setZagolovok();
    }

    @When("^I fill in SHORT TEXT field with \"([^\"]*)\"$")
    public void i_fill_in_short_text_field_with(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.setShortText(arg1);
    }

    @When("^I choose a news type \"([^\"]*)\"$")
    public void i_choose_a_news_type(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.selectNewsType(arg1);
    }

    @When("^I click on delete icon$")
    public void i_click_on_delete_icon() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.clickOnDeleteNewsItemButton();
    }

    @When("^I click on confirmation button$")
    public void i_click_on_confirmation_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.clickOnDeleteConfirmationButton();
    }

    @When("^I click on Submit button$")
    public void i_click_on_Submit_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.clickOnSubmitButton();
    }

    @When("^I click on Success button$")
    public void i_click_on_Success_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.clickOnSuccessButton();
    }

    @Then("^I am on news page in admin panel on URL \"([^\"]*)\"$")
    public void i_am_on_news_page_in_admin_panel_on_URL(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("https://someURL/admin/application/news/create", arg1);
    }

    @Then("^I see a new news item in the news table$")
    public void i_see_a_new_news_item_in_the_news_table() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.waitForNewsTableToLoad();
        newsPage.assertTextOfLastAddedNews();
    }

    @Then("^I don't see selected news item any more$")
    public void i_don_t_see_selected_news_item_any_more() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        newsPage.assertDeletedNewsItemIsAbsent();
    }
}
