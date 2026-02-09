package org.project.haloproject.web.stepdefinitions;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.project.haloproject.web.DriverManager;
import org.project.haloproject.web.pageobjects.HomePage;

public class InitSD {
    protected static final Logger LOGGER = LogManager.getLogger(InitSD.class);
    private final HomePage homePage;

    public InitSD() {
        this.homePage = new HomePage(DriverManager.getInstance().getDriver());
    }

    @Given("init test")
    public void initTest() {
        homePage.goTo();
        homePage.assertIsCurrentPage();
        homePage.getHeader().searchInputElement.isEnabled();
        homePage.getHeader().searchInputElement.sendKeys("Azorius");
        homePage.getHeader().searchButtonElement.submit();
        try {
            wait(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("Init Test");
    }

}
