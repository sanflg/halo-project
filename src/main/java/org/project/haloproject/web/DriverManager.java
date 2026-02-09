package org.project.haloproject.web;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private static final String DEFAULT_DRIVER_NAME = "DEFAULT";
    private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
    @Getter
    private static final DriverManager instance = new DriverManager();

    private final ThreadLocal<Map<String, WebDriver>> webDrivers = new ThreadLocal<>();

    private DriverManager() {
    }

    public WebDriver getDriver(String driverName) {
        Map<String, WebDriver> drivers = webDrivers.get();
        if (drivers == null) {
            drivers = new HashMap<>();
            webDrivers.set(drivers);
            LOGGER.info("Started DriverManager on thread {}", Thread.currentThread().getName());
        }
        WebDriver driver = drivers.get(driverName);
        if (driver == null) {
            LOGGER.info("Get driver");
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            drivers.put(driverName, driver);
        }
        return driver;
    }

    public WebDriver getDriver() {
        return getDriver(DEFAULT_DRIVER_NAME);
    }

    public void quitAll() {
        Map<String, WebDriver> drivers = webDrivers.get();
        if (drivers == null) {
            return;
        }
        for (WebDriver driver : drivers.values()) {
            driver.quit();
        }
        drivers.clear();
        webDrivers.remove();
    }
}
