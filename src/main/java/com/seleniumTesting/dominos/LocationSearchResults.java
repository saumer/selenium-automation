package com.seleniumTesting.dominos;

import com.seleniumTesting.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by jerem on 5/12/2016.
 */
public class LocationSearchResults {
    public static final String url = "http://www.dominos.com";

    //div
    public static final By divsSearchResults = By.className("location-search-result");
    public static final By divStreetAddress = By.className("location-search-result__address");


    //buttons
    public static final By btnOrderOnline = By.className("btn--block");

    public static List<WebElement> getStorLocationSearchResults(Browser currentBrowser){
        currentBrowser.webBrowserWait(4, LocationSearchResults.divsSearchResults);
        List<WebElement> searchResults = currentBrowser.webBrowser.findElements(LocationSearchResults.divsSearchResults);
        return searchResults;
    }


}
