package org.project.haloproject.web.pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderElement {
    protected final WebDriver driver;

    @FindBy (id = "query_string")
    public WebElement searchInputElement;
    @FindBy (className = "layout-navbar-search-btn")
    public WebElement searchButtonElement;
    @FindBy (className = "layout-header-banner-logo-img")
    public WebElement logoImgElement;

    public HeaderElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
