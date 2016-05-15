package com.seleniumTesting.weatherApi;

import com.seleniumTesting.utilities.ParsingUtils.BasicWeather;
import com.seleniumTesting.utilities.RestApi.WeatherRestApi;
import org.junit.Test;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jerem on 5/15/2016.
 */
public class WeatherApiTest {
    @Test
    public void checkExpectedKeysExist(){
        Set<String> expectedKeys = new HashSet<String>(Arrays.asList("dt", "coord", "weather",
                "name", "cod", "main", "clouds", "id", "sys", "base", "wind"));
        try {
            WeatherRestApi weatherReport = new WeatherRestApi();
            String weatherResults = weatherReport.getLocationWeather("London,UK");
            HashMap<String,Object> weatherObject = new ObjectMapper().readValue(weatherResults, HashMap.class);

            System.out.println(weatherObject.keySet().equals(expectedKeys)
            );

        } catch (java.io.IOException e){
            System.err.println(e);
        }
    }
}
