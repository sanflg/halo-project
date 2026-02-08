package org.project.haloProject.web.stepDefinitions;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.project.haloProject.web.DriverManager;
import org.project.haloProject.web.pageObjects.HomePage;

public class InitSD {
    protected static final Logger LOGGER = LogManager.getLogger(InitSD.class);
    private final HomePage homePage;

    public InitSD() {
        this.homePage = new HomePage(DriverManager.getInstance().getDriver());
    }

    @Given("init test")
    public void initTest() {
        homePage.goTo();
        LOGGER.info("Init Test");
    }

}
