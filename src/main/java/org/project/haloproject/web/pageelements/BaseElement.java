package org.project.haloproject.web.pageelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.project.haloproject.web.BasePageElement;

import java.time.Duration;

public class BaseElement extends BasePageElement {

    protected BaseElement(WebDriver driver) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(30)));
        PageFactory.initElements(driver, this);
    }
}
