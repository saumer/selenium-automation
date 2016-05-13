package com.seleniumTesting.dominos;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Keyboard;

import java.util.concurrent.TimeUnit;
import com.seleniumTesting.dominos.HomePage;
import com.seleniumTesting.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jerem on 5/12/2016.
 */

public class LocatorWorkflows {
    @Test
    public void annArborStoreLocatesSuccessfuly (){
        FirefoxDriver browser = Browser.webBrowser;
        System.out.println(HomePage.url);
        browser.get(HomePage.url);
        browser.findElement(HomePage.linkLocation).sendKeys(Keys.RETURN);


        Browser wait = new Browser();
        wait.webBrowserWait(4, LocationFinder.txtBoxCity);
        browser.findElement(LocationFinder.txtBoxCity).sendKeys("Annarbor");
        browser.findElement(LocationFinder.txtBoxZipCode).sendKeys("48104");

        browser.close();
    }

}
