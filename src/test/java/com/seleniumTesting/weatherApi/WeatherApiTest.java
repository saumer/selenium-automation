package com.seleniumTesting.weatherApi;

import com.seleniumTesting.utilities.ParsingUtils.BasicWeather;
import com.seleniumTesting.utilities.RestApi.WeatherRestApi;
import org.junit.Rule;
import org.junit.Test;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.rules.ErrorCollector;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by jerem on 5/15/2016.
 */
public class WeatherApiTest {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void checkExpectedKeysExist(){
        Set<String> expectedKeys = new HashSet<String>(Arrays.asList("dt", "coord", "weather",
                "name", "cod", "main", "clouds", "id", "sys", "base", "wind"));
        try {
            WeatherRestApi weatherReport = new WeatherRestApi();
            String weatherResults = weatherReport.getLocationWeather("London,UK");
            HashMap<String,Object> weatherObject = new ObjectMapper().readValue(weatherResults, HashMap.class);
            collector.checkThat(weatherObject.keySet().equals(expectedKeys), equalTo(true));
        } catch (java.io.IOException e){
            System.err.println(e);
        }
    }
}
