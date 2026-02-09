package org.project.haloproject.web.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.project.haloproject.web.config.EndpointManager;
import org.testng.Assert;

public class DeckPage extends BasePage {
    protected static final String DECK_PAGE = EndpointManager.getEndpoint().MtgGoldFishDeck();

    private static final String DECK_SUBMITTED_BY_USER_TEXT = "User Submitted Deck";

    private static final By DECK_INFO_ELEMENT = By.xpath("//p[@class='deck-container-information']");

    public DeckPage(WebDriver driver, String id) {
        super(driver, MAIN_PAGE + String.format(DECK_PAGE, id));
    }

    public DeckPage(WebDriver driver) {
        super(driver, MAIN_PAGE + DECK_PAGE);
    }

    @Step("Validate that the deck we entered via deck submitted by user menu, is indeed submitted by user.")
    public void validateDeckSubmittedByUser() {
        Assert.assertTrue(getWebElement(DECK_INFO_ELEMENT).getText().contains(DECK_SUBMITTED_BY_USER_TEXT),
                "User is not submitted by user, full info element: " + DECK_SUBMITTED_BY_USER_TEXT);
    }
}
