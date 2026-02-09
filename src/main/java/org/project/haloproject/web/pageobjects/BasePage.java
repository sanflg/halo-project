package org.project.haloproject.web.pageobjects;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.project.haloproject.web.BasePageElement;
import org.project.haloproject.web.config.EndpointManager;
import org.project.haloproject.web.pageelements.HeaderElement;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

@Getter
public class BasePage<T extends BasePage<T>> extends BasePageElement {
    protected static final String MAIN_PAGE = EndpointManager.getEndpoint().MtgGoldFishMain();
    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);
    protected URL url = null;

    private HeaderElement header;

    protected BasePage(WebDriver driver, String url) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(30)));
        try {
            this.url = new URI(url).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            LOGGER.error(String.format("Invalid URL <%s>", url), e);
        }
        PageFactory.initElements(driver, this);
    }

    @SuppressWarnings({"unchecked"})
    public T goTo() {
        driver.get(url.toString());

        LOGGER.info("Loading: {}", driver.getCurrentUrl());
        return (T) this;
    }

    public HeaderElement getHeader() {
        if (header == null) {
            this.header = new HeaderElement(driver);
        }
        return header;
    }
}
