package org.project.haloproject.web.pageelements;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.project.haloproject.web.pageobjects.DeckPage;

import java.util.List;

public class DeckDisplayElement extends BaseElement {
    private static final Logger LOGGER = LogManager.getLogger(DeckDisplayElement.class);
    private static final By PARENT_ELEMENT = By.xpath("//div[@class='archetype-tile']");
    private static final By DECK_NAME_ELEMENT = By.xpath(".//span[@class='deck-price-paper']/a");
    public DeckDisplayElement(WebDriver driver) {
        super(driver);
    }

    @Step("Get all the decks displayed in a page.")
    public List<WebElement> getAllDecksContainers() {
        LOGGER.info("Getting all card containers");

        return getWebElements(PARENT_ELEMENT);
    }

    @Step("Get the name of a deck starting from parent element.")
    public WebElement getDeckNameElement(WebElement parent) {
        LOGGER.info("Getting deck name element");

        return getWebElementFromParent(parent, DECK_NAME_ELEMENT);
    }

    @Step("Access a deck using index in page as location strategy, index: {0}.")
    public DeckPage goToDeckByIndex(int index) {
        LOGGER.info("Going to deck by index: {}", index);

        WebElement element = getDeckNameElement(getAllDecksContainers().get(index));
        LOGGER.info("Deck Name: {}", element.getText());

        element.click();

        return new DeckPage(driver);
    }
}
