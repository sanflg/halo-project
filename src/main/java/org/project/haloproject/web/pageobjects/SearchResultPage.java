package org.project.haloproject.web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage<SearchResultPage>{
    private final By decksTableElement = By.className("table-striped");

    public SearchResultPage(WebDriver driver, String searchText) {
        super(driver, DOMAIN + "/q?query_string=" + searchText);
    }

    public List<WebElement> getDecksTableElements() {
        return driver.findElements(decksTableElement);
    }
}
