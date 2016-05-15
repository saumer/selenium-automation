package com.seleniumTesting.utilities.ParsingUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by jerem on 5/15/2016.
 */
public class BasicWeather {
    private String weather;
    private String coord;

    public String getWeather(){return weather;}
    @JsonIgnore
    private String getCoord(){return coord;}


    public void setWeather(String newWeather){weather = newWeather;}
    public void setCoord(String newCoord){coord = newCoord;}
}
