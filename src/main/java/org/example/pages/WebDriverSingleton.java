package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverSingleton {
    private static WebDriver INSTANCE;

    private WebDriverSingleton() {
    }
        public static WebDriver getInstance () throws MalformedURLException {
            if (INSTANCE == null) {
                ChromeOptions chromeOptions = new ChromeOptions();
                INSTANCE = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), chromeOptions);;
            }
            return INSTANCE;
        }
    }
