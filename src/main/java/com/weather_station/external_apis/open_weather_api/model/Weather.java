package com.weather_station.external_apis.open_weather_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

    @JsonProperty("main")
    private String mainWeatherType;
    @JsonProperty("description")
    private String weatherDescription;

    public String getMainWeatherType() {
        return mainWeatherType;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "mainWeatherType='" + mainWeatherType + '\'' +
                ", weatherDescription='" + weatherDescription + '\'' +
                '}';
    }
}
