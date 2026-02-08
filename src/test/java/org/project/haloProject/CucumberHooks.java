package org.project.haloProject;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CucumberHooks {
    protected static final Logger LOGGER = LogManager.getLogger(CucumberHooks.class);

    @Before
    public void cucumberBefore(Scenario scenario) {
        LOGGER.info("Before Scenario: {}", scenario.getName());
    }
}
