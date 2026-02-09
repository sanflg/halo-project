package org.project.haloproject.web.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.project.haloproject.web.DriverManager;
import org.project.haloproject.web.pageobjects.DeckPage;
import org.project.haloproject.web.pageobjects.DecksDisplayPage;
import org.project.haloproject.web.pageobjects.HomePage;

public class DeckViewSD {
    protected static final Logger LOGGER = LogManager.getLogger(DeckViewSD.class);
    private final HomePage homePage;
    private DecksDisplayPage decksDisplayPage;
    private DeckPage deckPage;

    public DeckViewSD() {
        this.homePage = new HomePage(DriverManager.getInstance().getDriver());
    }

    @When("user goes to users submitted decks page")
    public void goToUserSubmittedDecksPage() {
        decksDisplayPage = homePage.getHeader().goToUserSubmittedDecksPage();
    }

    @When("user goes to deck number: {}")
    public void goToDeckNumber(int index) {
        deckPage = decksDisplayPage.getDeckDisplayElement().goToDeckByIndex(index);
    }

    @Then("deck is submitted by user")
    public void deckIsSubmittedByUser() {
        deckPage.validateDeckSubmittedByUser();
    }
}
