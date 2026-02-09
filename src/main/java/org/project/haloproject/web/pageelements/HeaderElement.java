package org.project.haloproject.web.pageelements;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.project.haloproject.web.pageobjects.DecksDisplayPage;
import org.project.haloproject.web.pageobjects.SearchResultPage;

@Getter
public class HeaderElement extends BaseElement {
    private static final Logger LOGGER = LogManager.getLogger(HeaderElement.class);

    private static final By SEARCH_INPUT_ELEMENT = By.xpath("//header//input");
    private static final By SEARCH_BUTTON_ELEMENT = By.xpath("//header//button[@aria-label='Search Submit']");

    private static final String HEADER_OPTIONS_LOCATOR = "//header//li[@class='nav-item dropdown'][%s]";
    private static final String HEADER_SUB_OPTIONS_LOCATOR = "(//li[@class='nav-item dropdown show']//a[@class='dropdown-item'])[%s]";

    public HeaderElement(WebDriver driver) {
        super(driver);
    }

    @Getter
    public enum HeaderDropdownOption {
        CARDS (1),
        DECKS (2),
        TOOLS (3),
        LOGIN (4);

        private final int index;

        HeaderDropdownOption(int index) {
            this.index = index;
        }
    }

    @Getter
    public enum HeaderDecksOption {
        POPULAR_DECKS   (1),
        USER_SUBMITTED  (2),
        CREATE          (3),
        PRICE           (4),
        SEARCH          (5),
        TOURNAMENTS     (6),
        SUPER_BREW      (7),
        MY_DECKS        (8);

        private final HeaderDropdownOption master;
        private final int index;

        HeaderDecksOption(int index) {
            this.master = HeaderDropdownOption.DECKS;
            this.index = index;
        }
    }

    public SearchResultPage search(String text) {
        getWebElement(SEARCH_INPUT_ELEMENT).sendKeys(text);
        getWebElement(SEARCH_BUTTON_ELEMENT).click();

        LOGGER.info("searching: {}", text);

        return new SearchResultPage(driver, text);
    }

    public DecksDisplayPage goToUserSubmittedDecksPage() {
        clickSubOptionHeaderDropdown(HeaderDecksOption.USER_SUBMITTED);

        LOGGER.info("Navigating to user submitted decks");

        return new DecksDisplayPage(driver);
    }

    public void clickHeaderDropdown(HeaderDropdownOption item){
        String optionLocator = String.format(HEADER_OPTIONS_LOCATOR, item.getIndex());

        LOGGER.info("Clicking header dropdown: {}", optionLocator);

        getWebElement(By.xpath(optionLocator)).click();
    }

    public void clickSubOptionHeaderDropdown(HeaderDecksOption item){
        clickHeaderDropdown(item.getMaster());
        String optionLocator = String.format(HEADER_SUB_OPTIONS_LOCATOR, item.getIndex());

        LOGGER.info("Clicking header sup option dropdown: {}", optionLocator);

        getWebElement(By.xpath(optionLocator)).click();
    }


}
