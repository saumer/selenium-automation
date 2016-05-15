package com.seleniumTesting.utilities.RestApi;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.seleniumTesting.utilities.ParsingUtils.BasicWeather;
import com.seleniumTesting.utilities.ParsingUtils.UserAddress;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by jerem on 5/15/2016.
 */
public class WeatherRestApi {
    String uri = "http://api.openweathermap.org/data/2.5/weather";
    private Set<String> expectedKeys = new HashSet<String>(Arrays.asList("dt", "coord", "weather",
            "name", "cod", "main", "clouds", "id", "sys", "base", "wind"));

    public  WeatherRestApi(){
        String uri = "http://api.openweathermap.org/data/2.5/weather";
    }

    public String getLocationWeather(String location){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("q", location)
                .queryParam("appid", "973f7c4dccaa422921add219c3051e63");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(builder.build().encode().toUri(), String.class);
        System.out.println(result);
        return result;
    }

    public BasicWeather parseLocationWeather(String weather)throws java.io.IOException {
        ObjectMapper mapper = new ObjectMapper();
        BasicWeather weatherObject = mapper.readValue(weather, BasicWeather.class);
        return weatherObject;
    }

    public boolean topLevelKeysExist(String location) throws java.io.IOException {
        WeatherRestApi weatherReport = new WeatherRestApi();
        String weatherResults = weatherReport.getLocationWeather(location);
        HashMap<String,Object> weatherObject = new ObjectMapper().readValue(weatherResults, HashMap.class);
        return weatherObject.keySet().equals(expectedKeys);
    }
}
