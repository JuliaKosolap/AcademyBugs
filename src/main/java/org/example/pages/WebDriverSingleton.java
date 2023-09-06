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
                INSTANCE = new ChromeDriver();
            }
            return INSTANCE;
        }
    }
