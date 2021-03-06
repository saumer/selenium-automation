package com.seleniumTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


/**
 * Created by Jeremy on 4/29/2016.
 */
public class Browser {
    public FirefoxDriver webBrowser = new FirefoxDriver();


    public FirefoxDriver createBrowser() {
        return webBrowser;
    }

    public void webBrowserWait(int time, By element) {
        WebDriverWait browserWait = new WebDriverWait(webBrowser, time);
        browserWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


    public void close() {
        webBrowser.close();
    }
}
