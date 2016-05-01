package com.seleniumTesting.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jeremy on 4/29/2016.
 */
public class Browser {
    public static FirefoxDriver webBrowser = new FirefoxDriver();

    public static FirefoxDriver createBrowser() {
        return webBrowser;
    }

    public static void close() {
        webBrowser.close();
    }
}
