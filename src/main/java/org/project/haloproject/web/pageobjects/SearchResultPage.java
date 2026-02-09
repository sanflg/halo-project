package org.project.haloproject.web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.project.haloproject.web.config.EndpointManager;

import java.util.List;

public class SearchResultPage extends BasePage<SearchResultPage> {
    protected static final String SEARCH_PAGE = EndpointManager.getEndpoint().MtgGoldFishSearch();

    private final By decksTableElement = By.className("table-striped");

    public SearchResultPage(WebDriver driver, String searchText) {
        super(driver, MAIN_PAGE + SEARCH_PAGE + searchText);
    }

    public List<WebElement> getDecksTableElements() {
        return driver.findElements(decksTableElement);
    }
}
