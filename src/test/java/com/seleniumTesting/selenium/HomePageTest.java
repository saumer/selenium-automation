package com.seleniumTesting.selenium;

/**
 * Created by Jeremy on 4/29/2016.
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.seleniumTesting.selenium.Driver;
import java.util.concurrent.TimeUnit;


public class HomePageTest {
    @Test
    public void testSeachButtonExists(){

        FirefoxDriver browser = Driver.createFireFoxDriver();
        System.out.println(HomePage.url);
        browser.get(HomePage.url);
        System.out.println(HomePage.searchButton);
        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e)
        {

        }
        Boolean isPresent = browser.findElements(HomePage.searchBox).size() > 0;
        System.out.println(isPresent);
        assert(isPresent);

        isPresent = browser.findElements(HomePage.searchButton).size() > 0;
        System.out.println(isPresent);
        assert(isPresent);

        browser.findElement(HomePage.searchBox).sendKeys("test text here");
        browser.findElement(HomePage.searchButton).click();
        ExpectedConditions.urlContains("doBasicSearch?Query=");


    }
}