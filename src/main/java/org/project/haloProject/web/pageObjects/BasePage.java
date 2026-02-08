package org.project.haloProject.web.pageObjects;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

abstract class BasePage<T extends BasePage<T>> {
    protected static final Logger LOGGER = LogManager.getLogger(BasePage.class);
    protected static final String DOMAIN = "https://www.mtggoldfish.com/";
    protected final WebDriver driver;
    protected URL url = null;

    protected BasePage(WebDriver driver, String url) {
        this.driver = driver;
        try {
            this.url = new URI(url).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            LOGGER.error(String.format("Invalid URL <%s>", url), e);
        }
        PageFactory.initElements(driver, this);
    }

    public void assertIsCurrentPage() {
        assertEquals(driver.getCurrentUrl(), DOMAIN);
    }

    @SuppressWarnings({"unchecked"})
    public T goTo() {
        driver.get(url.toString());
        return (T) this;
    }
}
