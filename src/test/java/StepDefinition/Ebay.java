package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static General.WebUtility.*;


public class Ebay {

    private static ChromeDriver _driver;

    @Given("^User redirect to \"([^\"]*)\"$")
    public void user_redirect_to(String url) throws Exception {
        getChromeInstance();
        redirectTo(url);
    }

    @Given("^User navigate to Search by Category$")
    public void user_navigate_to_Search_by_Category() throws Exception {
        waitAndClick(By.id("gh-shop-a"));
    }

    @Given("^User click on Cellphone & Accessories$")
    public void user_click_on_Cellphone_Accessories() throws Exception {
        waitAndClick(By.xpath("//a[.='Cell phones & accessories']"));
    }

    @Given("^User click on Cellphone & Smartphone$")
    public void user_click_on_Cellphone_Smartphone() throws Exception {
        waitAndClick(By.xpath("//section[@class='b-module b-list b-speciallinks b-display--landscape']//a[.='Cell Phones & Smartphones']"));
    }

    @When("^User Click on More Refinements$")
    public void user_Click_on_More_Refinements() throws Exception {
        pageScrollInView(By.xpath("//button[.='More refinementsMore refinements...']"));
        waitAndClick(By.xpath("//button[.='More refinementsMore refinements...']"));
    }

    @When("^User select \"([^\"]*)\" tags$")
    public void user_select_tags(String tag) throws Exception {
        waitAndClick(By.xpath("//span[.='"+tag+"']"));

    }
    @Then("^system show selected \"([^\"]*)\" tags on result$")
    public void system_show_selected_tags_on_result(String tagResult) throws Exception {
        waitForPresent(By.xpath("//div[@class='x-tray__breadcrumbs']/span[.='"+tagResult+"']"));
    }

    @Then("^system show \"([^\"]*)\" filters selected$")
    public void system_show_filters_selected(String numberOfResult) throws Exception {

        Assert.assertTrue(getText(By.xpath("//span[@class='x-tray__count']")).contains(numberOfResult));
    }

    @Given("^User type \"([^\"]*)\" on the search bar$")
    public void user_type_on_the_search_bar(String product) throws Exception {
       waitAndFill(By.id("gh-ac"),product);
    }

    @Given("^User select Category \"([^\"]*)\"$")
    public void user_select_Category(String category) throws Exception {
        waitAndClick(By.id("gh-cat"));
        waitAndClick(By.xpath("//option[.='"+category+"']"));
    }

    @When("^User click Search button$")
    public void user_click_Search_button() throws Exception {
        waitAndClick(By.id("gh-btn"));
    }

    @Then("^system load result completely$")
    public void system_load_result_completely() throws Exception {
        waitForPresent(By.cssSelector(".srp-controls__count-heading"));
    }

    @Then("^system show first result matches \"([^\"]*)\"$")
    public void system_show_first_result_matches(String product) throws Exception {
     Assert.assertTrue(getText(By.xpath("(//*[@class='s-item__title s-item__title--has-tags']/span)[1]")).contains(product.toUpperCase()));
    }
}
