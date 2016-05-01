package com.seleniumTesting.selenium;

/**
 * Created by Jeremy on 5/1/2016.
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.seleniumTesting.selenium.Browser;
import java.util.concurrent.TimeUnit;

public class ItemViewPageTest {


    @Test
    public void validateItemViewPageMetadata(){
        String s3Type = AwsUtilitesS3.getStringFromS3("saumer-selenium-data","basic_sample.json");
    }


}
