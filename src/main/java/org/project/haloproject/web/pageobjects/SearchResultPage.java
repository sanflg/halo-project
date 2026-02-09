package org.project.haloproject.web.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.project.haloproject.web.config.EndpointManager;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchResultPage extends BasePage {
    protected static final String SEARCH_PAGE = EndpointManager.getEndpoint().MtgGoldFishSearch();

    private final By decksTableElement = By.className("table-striped");

    public SearchResultPage(WebDriver driver, String searchText) {
        super(driver, MAIN_PAGE + SEARCH_PAGE + searchText);
    }

    @Step("Get deck table element in order to access the decks.")
    public List<WebElement> getDecksTableElements() {
        return driver.findElements(decksTableElement);
    }

    @Step("Validate the lexical search of decks/cards on the search menu by term: {0}.")
    public void validateDecksTableElements(String term) {
        SoftAssert softAssert = new SoftAssert();

        for (WebElement element : getDecksTableElements()) {
            softAssert.assertTrue(
                    element.getText().toLowerCase().contains(term),
                    "Deck name does not contain term: " + element.getText());
        }

        softAssert.assertAll();
    }
}
