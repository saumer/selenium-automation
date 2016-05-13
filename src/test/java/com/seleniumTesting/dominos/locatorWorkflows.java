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

        System.out.println(HomePage.url);
        currentBrowser.webBrowser.get(HomePage.url);
        currentBrowser.webBrowser.findElement(HomePage.linkLocation).sendKeys(Keys.RETURN);


        currentBrowser.webBrowserWait(4, LocationFinder.txtBoxCity);
        currentBrowser.webBrowser.findElement(LocationFinder.txtBoxCity).sendKeys("Annarbor");
        currentBrowser.webBrowser.findElement(LocationFinder.txtBoxZipCode).sendKeys("48104");
        Select select = new Select(currentBrowser.webBrowser.findElement(LocationFinder.selectState));
        select.selectByVisibleText("MI");
        currentBrowser.webBrowser.findElement(LocationFinder.btnSearchLocations).click();
        List<WebElement> searchResults = currentBrowser.webBrowser.findElements(LocationSearchResults.divsSearchResults);
        System.out.println(searchResults.size());

        for (int i = 0; i < searchResults.size(); i++) {
            WebElement orderButton = searchResults.get(i).findElement(btnOrderOnline);
            collector.checkThat(orderButton.getText(), equalTo("ORDER CARRYOUT / PICKUP"));
        }
        currentBrowser.close();
    }

}
