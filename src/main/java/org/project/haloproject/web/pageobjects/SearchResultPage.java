package org.project.haloproject.web.pageobjects;

import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage<SearchResultPage>{

    public SearchResultPage(WebDriver driver, String searchText) {
        super(driver, "https://www.mtggoldfish.com/q?query_string=" + searchText);
    }
}
