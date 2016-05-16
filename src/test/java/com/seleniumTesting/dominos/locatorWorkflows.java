package com.seleniumTesting.dominos;

import com.seleniumTesting.utilities.RestApi.WeatherRestApi;
import com.seleniumTesting.utilities.ParsingUtils.UserAddress;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Keyboard;


import java.util.List;
import java.util.regex.Pattern;

import com.seleniumTesting.Browser;

import com.seleniumTesting.utilities.ParsingUtils.JsonParsingUtils;

import static com.seleniumTesting.dominos.LocationSearchResults.btnOrderOnline;
import static com.seleniumTesting.dominos.LocationSearchResults.divStreetAddress;
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
        LocationFinder.setRequiredLocationInfo(currentBrowser,"","","Annarbor","MI","48108");
        currentBrowser.webBrowser.findElement(LocationFinder.btnSearchLocations).click();
        List<WebElement> searchResults = LocationSearchResults.getStorLocationSearchResults(currentBrowser);
        
        collector.checkThat(searchResults.size(), equalTo(10));
        for (int i = 0; i < searchResults.size(); i++) {
            WebElement orderButton = searchResults.get(i).findElement(btnOrderOnline);
            collector.checkThat(orderButton.getText(), equalTo("ORDER CARRYOUT / PICKUP"));
        }
        currentBrowser.close();
    }

    @Test
    public void incorectZipCodeBehavesCorrectly() {
        Browser currentBrowser = new Browser();
        currentBrowser.webBrowser.get(LocationFinder.url);
        currentBrowser.webBrowserWait(4, LocationFinder.txtBoxCity);
        LocationFinder.setRequiredLocationInfo(currentBrowser,"","","Annarbor","MI","48-08");
        String zipCode = currentBrowser.webBrowser.findElement(LocationFinder.txtBoxZipCode).getAttribute("value");
        collector.checkThat(zipCode, equalTo("4808"));
        currentBrowser.close();
    }

    @Test
    public void checkDeliveryStores(){
        Browser currentBrowser = new Browser();
        try {
            List<UserAddress> myObjects = JsonParsingUtils.getAndParseUserAddress("C:\\Users\\jerem\\Documents\\json_for_automation\\location_import_examples.json");
            for (int i = 0; i < myObjects.size(); i++) {
                currentBrowser.webBrowser.get(LocationFinder.url);
                currentBrowser.webBrowserWait(4, LocationFinder.txtBoxCity);

                UserAddress location = myObjects.get(i);
                LocationFinder.setRequiredLocationInfo(currentBrowser,location.getStreet(),location.getAptNum(), location.getCity(),location.getState(),location.getZipcode());
                currentBrowser.webBrowser.findElement(LocationFinder.btnSearchLocations).click();

                List<WebElement> searchResults = LocationSearchResults.getStorLocationSearchResults(currentBrowser);
                collector.checkThat(searchResults.get(0).getAttribute("data-type"), equalTo("Delivery"));
                Boolean test = Pattern.compile(Pattern.quote(location.getStoreAddress()), Pattern.CASE_INSENSITIVE).matcher(searchResults.get(0).findElement(divStreetAddress).getText()).find();
                collector.checkThat(test, equalTo(true));
            }
        }
        catch (java.io.IOException e){ System.err.print(e);
        }
        currentBrowser.close();
    }

}
