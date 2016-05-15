package com.seleniumTesting.dominos;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.seleniumTesting.Browser;

/**
 * Created by jerem on 5/12/2016.
 */
public class LocationFinder {
    public static final String url = "http://www.dominos.com/en/pages/order/?locations=1#/locations/";

    //buttons
    public static final By btnSearchLocations = By.className("c-locationsearch-search-cta");

    //textboxes
    public static final By txtBoxCity = By.id("City");
    public static final By txtBoxZipCode = By.id("Postal_Code");
    public static final By txtBoxStreet = By.id("Street");
    public static final By txtAptNum = By.id("Address_Line_2");


    //select dropdown
    public static final By selectState = By.id("Region");

    public static void setRequiredLocationInfo(Browser currentBrowser,String street, String aptnum, String city, String state, String zip) {
        currentBrowser.webBrowser.findElement(LocationFinder.txtBoxStreet).clear();
        currentBrowser.webBrowser.findElement(LocationFinder.txtAptNum).clear();
        currentBrowser.webBrowser.findElement(LocationFinder.txtBoxCity).clear();
        currentBrowser.webBrowser.findElement(LocationFinder.txtBoxZipCode).clear();

        currentBrowser.webBrowser.findElement(LocationFinder.txtBoxStreet).sendKeys(street);
        currentBrowser.webBrowser.findElement(LocationFinder.txtAptNum).sendKeys(aptnum);
        currentBrowser.webBrowser.findElement(LocationFinder.txtBoxCity).sendKeys(city);
        currentBrowser.webBrowser.findElement(LocationFinder.txtBoxZipCode).sendKeys(zip);
        Select select = new Select(currentBrowser.webBrowser.findElement(LocationFinder.selectState));
        select.selectByVisibleText(state);
    }

}
