package org.project.haloproject.web.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.project.haloproject.web.DriverManager;
import org.project.haloproject.web.pageobjects.HomePage;
import org.project.haloproject.web.pageobjects.SearchResultPage;
import org.testng.Assert;

public class SearchSD {
    protected static final Logger LOGGER = LogManager.getLogger(SearchSD.class);
    private final HomePage homePage;
    private SearchResultPage searchResultPage;

    public SearchSD() {
        this.homePage = new HomePage(DriverManager.getInstance().getDriver());
    }

    @Given("user goes to main page")
    public void goToMainPage() {
        homePage.goTo();
    }

    @When("user does a search with term: {}")
    public void search(String term) {
        searchResultPage = homePage.getHeader().search(term);
    }

    @Then("all decks contains in the name the term: {}")
    public void decksNameCheck(String term) {
        for (WebElement element : searchResultPage.getDecksTableElements()) {
            Assert.assertTrue(
                    element.getText().toLowerCase().contains(term),
                    "Deck name does not contain term: " + element.getText());
        }
    }

}
