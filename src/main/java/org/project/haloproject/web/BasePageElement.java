package org.project.haloproject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageElement {
    protected final WebDriver driver;
    protected WebDriverWait wait;

    public BasePageElement(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public WebElement getWebElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
