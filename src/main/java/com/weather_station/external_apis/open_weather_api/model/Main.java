package com.weather_station.external_apis.open_weather_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

    @JsonProperty("temp")
    private Float temperature;
    @JsonProperty("feels_like")
    private Float temperatureSensed;
    @JsonProperty("pressure")
    private Integer pressure;
    @JsonProperty("humidity")
    private Integer humidity;

    public Float getTemperature() {
        return temperature;
    }

    public Float getTemperatureSensed() {
        return temperatureSensed;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temperature=" + temperature +
                ", temperatureSensed=" + temperatureSensed +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}
