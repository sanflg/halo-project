package org.project.haloproject.web.pageobjects;

import org.openqa.selenium.WebDriver;
import org.project.haloproject.web.config.EndpointManager;
import org.project.haloproject.web.pageelements.DeckDisplayElement;

public class DecksDisplayPage extends BasePage<DecksDisplayPage> {
    protected static final String DECKS_PAGE = EndpointManager.getEndpoint().MtgGoldFishDecks();

    private DeckDisplayElement deckDisplayElement;

    public DecksDisplayPage(WebDriver driver) {
        super(driver, MAIN_PAGE + DECKS_PAGE);
    }

    public DeckDisplayElement getDeckDisplayElement() {
        if (deckDisplayElement == null) {
            this.deckDisplayElement = new DeckDisplayElement(driver);
        }
        return deckDisplayElement;
    }

}
