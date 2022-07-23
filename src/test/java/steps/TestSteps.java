package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.ResultsPage;
import tests.TestBase;

import java.util.List;

public class TestSteps extends TestBase {
    // page objects
    HomePage homePage;
    ResultsPage resultsPage;

    @Given("I am a non-registered customer")
    public void iAmANonRegisteredCustomer() {
    }

    @And("I navigate to {string}")
    public void iNavigateToHomePage(String url) {
        driver.navigate().to(url);
        homePage = new HomePage(driver);
    }

    @When("I search for an {string}")
    public void iSearchForAnItem(String searchKeyword) {
        homePage.searchFor(searchKeyword);
    }

    @Then("I get a list of matching results")
    public void iGetAListOfMatchingResults() {
        resultsPage = new ResultsPage(driver);

        List<WebElement> searchResultsList = resultsPage.getSearchResultsList();
        System.out.println("Number of search results: " + searchResultsList.size());
        Assert.assertTrue(searchResultsList.size() > 0);
    }
    @And("I get a few ads items results")
    public void iGetAFewAdsItemsResults() {
        List<WebElement> resultsAdsList = resultsPage.getResultsAdsElementsList();
        System.out.println("Number of Ads results: " + resultsAdsList.size());
        Assert.assertTrue(resultsAdsList.size() > 0);
    }

    @And("I can verify that all ads items titles are displayed")
    public void iCanVerifyThatAllAdsItemsTitlesIsDisplayed() {
        Assert.assertTrue(resultsPage.isAllAdsResultsTitlesDisplayed());
    }
}
