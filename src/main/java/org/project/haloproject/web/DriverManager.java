package org.project.haloproject.web;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.project.haloproject.web.config.Config;

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
            LOGGER.info("Started DriverManager on thread {}", Thread.currentThread().getName());

            drivers = new HashMap<>();
            webDrivers.set(drivers);
        }
        WebDriver driver = drivers.get(driverName);

        if (driver == null) {
            LOGGER.info("Started new driver on driver manager");

            driver = initDriver();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.timeout()));

            if (Config.maximize()) {
                driver.manage().window().maximize();
            }
            drivers.put(driverName, driver);
        }
        return driver;
    }

    public WebDriver getDriver() {
        return getDriver(DEFAULT_DRIVER_NAME);
    }

    public void quitAll() {
        Map<String, WebDriver> drivers = webDrivers.get();
        if (drivers == null || drivers.isEmpty()) {
            LOGGER.warn("quitAll called but no drivers found on thread {}", Thread.currentThread().getName());
            return;
        }
        LOGGER.info("Closing {} driver(s) on thread {}", drivers.size(), Thread.currentThread().getName());
        for (WebDriver driver : drivers.values()) {
            try {
                driver.quit();
                LOGGER.info("Driver closed successfully");
            } catch (Exception e) {
                LOGGER.error("Failed to close driver", e);
            }
        }
        drivers.clear();
        webDrivers.remove();
    }

    public WebDriver initDriver() {
        LOGGER.info("Init driver of type: {}", Config.browser().name());

        return switch (Config.browser()) {
            case FIREFOX -> {
                FirefoxOptions options = new FirefoxOptions();
                configure(options);
                yield new FirefoxDriver(options);
            }

            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                configure(options);
                yield new ChromeDriver(options);
            }
        };
    }

    private void configure(MutableCapabilities options) {
        if (Config.headless()) {
            if (options instanceof ChromeOptions chrome) {
                chrome.addArguments("--headless=new");
            }

            if (options instanceof FirefoxOptions firefox) {
                firefox.addArguments("-headless");
            }
        }
    }
}
