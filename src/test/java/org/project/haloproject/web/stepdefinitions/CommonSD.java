package org.project.haloproject.web.stepdefinitions;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.project.haloproject.web.DriverManager;
import org.project.haloproject.web.pageobjects.HomePage;

public class CommonSD {
    protected static final Logger LOGGER = LogManager.getLogger(CommonSD.class);
    private final HomePage homePage;

    public CommonSD() {
        this.homePage = new HomePage(DriverManager.getInstance().getDriver());
    }

    @Given("user goes to main page")
    public void goToMainPage() {
        homePage.goTo();
    }
}
