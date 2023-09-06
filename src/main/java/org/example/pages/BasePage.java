package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) throws MalformedURLException {
        this.driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }
}
