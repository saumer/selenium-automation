package com.seleniumTesting.jstor;

/**
 * Created by Jeremy on 4/29/2016.
 */

import com.seleniumTesting.Browser;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


public class HomePageTest {


    @Test
    public void testSeachButtonExists(){

        Browser currentBrowser = new Browser();
        currentBrowser.webBrowser.get(HomePage.url);
        currentBrowser.webBrowserWait(5, HomePage.searchBox);
        Boolean isPresent = currentBrowser.webBrowser.findElements(HomePage.searchBox).size() > 0;
        assert(isPresent);

        isPresent = currentBrowser.webBrowser.findElements(HomePage.searchButton).size() > 0;
        assert(isPresent);

        currentBrowser.webBrowser.findElement(HomePage.searchBox).sendKeys("test text here");
        currentBrowser.webBrowser.findElement(HomePage.searchButton).click();
        String url = currentBrowser.webBrowser.getCurrentUrl();
        assert(url.contains("doBasicSearch?Query"));

        currentBrowser.webBrowser.close();
    }
}