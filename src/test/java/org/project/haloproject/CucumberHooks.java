package org.project.haloproject;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.project.haloproject.web.DriverManager;

public class CucumberHooks {
    protected static final Logger LOGGER = LogManager.getLogger(CucumberHooks.class);

    @AfterAll
    public void cucumberAfterAllTest(Scenario scenario) {
        LOGGER.info("After Scenario: {}, Status: {}", scenario.getName(), scenario.getStatus());
        DriverManager.getInstance().quitAll();
    }
}
