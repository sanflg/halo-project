package org.project.haloProject.web.stepDefinitions;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InitSD {
    protected static final Logger LOGGER = LogManager.getLogger(InitSD.class);

    @Given("init test")
    public void initTest() {
        LOGGER.info("Init Test");
    }

}
