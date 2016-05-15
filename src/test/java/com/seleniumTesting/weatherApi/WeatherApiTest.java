package com.seleniumTesting.weatherApi;

import com.seleniumTesting.utilities.ParsingUtils.BasicWeather;
import com.seleniumTesting.utilities.RestApi.WeatherRestApi;
import org.junit.Rule;
import org.junit.Test;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.rules.ErrorCollector;

import java.util.*;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by jerem on 5/15/2016.
 */
public class WeatherApiTest {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void checkExpectedKeysExist(){
        WeatherRestApi weatherObject = new WeatherRestApi();
        ArrayList<String> locations = new ArrayList<String>();
        Collections.addAll(locations, "London, UK", "Detroit, MI", "Aiken, GA", "Accra GH");
        try {
            for (int i = 0; i < locations.size(); i++){
                Boolean keysMatch = weatherObject.topLevelKeysExist(locations.get(i));
                collector.checkThat(keysMatch, equalTo(true));
            }
        } catch (java.io.IOException e){
            System.err.println(e);
        }
    }
}
