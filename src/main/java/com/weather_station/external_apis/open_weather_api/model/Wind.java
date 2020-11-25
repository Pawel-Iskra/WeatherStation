package com.weather_station.external_apis.open_weather_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {

    @JsonProperty("speed")
    private Float speed;
    @JsonProperty("deg")
    private Integer degrees;

    public Float getSpeed() {
        return speed;
    }

    public Integer getDegrees() {
        return degrees;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", degrees=" + degrees +
                '}';
    }
}
