package com.seleniumTesting.dominos;

import org.openqa.selenium.By;

/**
 * Created by jerem on 5/12/2016.
 */
public class LocationFinder {
    public static final String url = "http://www.dominos.com";

    //buttons
    public static final By btnSearchLocations = By.className("c-locationsearch-search-cta");

    //textboxes
    public static final By txtBoxCity = By.id("City");
    public static final By txtBoxZipCode = By.id("Postal_Code");

    //select dropdown
    public static final By selectState = By.id("Region");



}
