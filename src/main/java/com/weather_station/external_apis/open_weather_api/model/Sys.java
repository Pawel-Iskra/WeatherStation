package com.weather_station.external_apis.open_weather_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sys {

    @JsonProperty("country")
    private String country;

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Sys{" +
                "country='" + country + '\'' +
                '}';
    }
}
