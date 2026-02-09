package org.project.haloproject.web.pageelements;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.project.haloproject.web.pageobjects.SearchResultPage;

@Getter
public class HeaderElement extends BaseElement {
    private static final Logger LOGGER = LogManager.getLogger(HeaderElement.class);

    private final By searchInputElement = By.xpath("//header//*[@id='query_string']");
    private final By searchButtonElement = By.xpath("//header//*[@aria-label='Search Submit']");
    private final By logoImgElement = By.className("layout-header-banner-logo-img");

    public HeaderElement(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage search(String text) {
        getWebElement(searchInputElement).sendKeys(text);
        getWebElement(searchButtonElement).click();
        return new SearchResultPage(driver, text);
    }
}
