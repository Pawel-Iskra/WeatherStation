package com.weather_station.external_apis.open_weather_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {

    @JsonProperty("lon")
    private Float longitude;
    @JsonProperty("lat")
    private Float latitude;

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
