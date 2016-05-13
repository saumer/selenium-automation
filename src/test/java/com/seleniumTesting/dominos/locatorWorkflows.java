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
        Browser currentBrowser = new Browser();

        System.out.println(HomePage.url);
        currentBrowser.webBrowser.get(HomePage.url);
        currentBrowser.webBrowser.findElement(HomePage.linkLocation).sendKeys(Keys.RETURN);


        currentBrowser.webBrowserWait(4, LocationFinder.txtBoxCity);
        currentBrowser.webBrowser.findElement(LocationFinder.txtBoxCity).sendKeys("Annarbor");
        currentBrowser.webBrowser.findElement(LocationFinder.txtBoxZipCode).sendKeys("48104");

        currentBrowser.close();
    }

}
