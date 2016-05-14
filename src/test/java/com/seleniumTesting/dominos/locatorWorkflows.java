package com.seleniumTesting.dominos;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Keyboard;

import java.util.List;
import java.util.concurrent.TimeUnit;
import com.seleniumTesting.dominos.HomePage;
import com.seleniumTesting.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.seleniumTesting.dominos.LocationSearchResults.btnOrderOnline;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by jerem on 5/12/2016.
 */

public class LocatorWorkflows {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void annArborStoreLocatesSuccessfuly (){
        Browser currentBrowser = new Browser();

        currentBrowser.webBrowser.get(HomePage.url);
        currentBrowser.webBrowser.findElement(HomePage.linkLocation).sendKeys(Keys.RETURN);

        currentBrowser.webBrowserWait(4, LocationFinder.txtBoxCity);
        LocationFinder.setRequiredLocationInfo(currentBrowser,"Annarbor","MI","48108");
        currentBrowser.webBrowser.findElement(LocationFinder.btnSearchLocations).click();
        currentBrowser.webBrowserWait(4, LocationSearchResults.divsSearchResults);
        List<WebElement> searchResults = currentBrowser.webBrowser.findElements(LocationSearchResults.divsSearchResults);
        
        collector.checkThat(searchResults.size(), equalTo(10));
        for (int i = 0; i < searchResults.size(); i++) {
            WebElement orderButton = searchResults.get(i).findElement(btnOrderOnline);
            collector.checkThat(orderButton.getText(), equalTo("ORDER CARRYOUT / PICKUP"));
            collector.checkThat(orderButton.getText(), equalTo("ORDER CARRYOUT / PICKUP"));
        }
        currentBrowser.close();
    }

    @Test
    public void incorectZipCodeBehavesCorrectly() {
        Browser currentBrowser = new Browser();
        currentBrowser.webBrowser.get(LocationFinder.url);
        LocationFinder.setRequiredLocationInfo(currentBrowser,"Annarbor","MI","48-08");
        String zipCode = currentBrowser.webBrowser.findElement(LocationFinder.txtBoxZipCode).getAttribute("value");
        collector.checkThat(zipCode, equalTo("4808"));
        currentBrowser.close();
    }

}
