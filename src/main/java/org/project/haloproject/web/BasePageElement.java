package org.project.haloproject.web;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageElement {
    protected final WebDriver driver;
    protected WebDriverWait wait;

    public BasePageElement(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @Step("Get an element with expected condition of visibility using by.")
    public WebElement getWebElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @Step("Get a list of elements with expected condition of visibility using by.")
    public List<WebElement> getWebElements(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    @Step("Get an element with expected condition of visibility using by starting from parent element.")
    public WebElement getWebElementFromParent(WebElement parent, By child) {
        return wait.until(ExpectedConditions.visibilityOf(parent.findElement(child)));
    }
}
