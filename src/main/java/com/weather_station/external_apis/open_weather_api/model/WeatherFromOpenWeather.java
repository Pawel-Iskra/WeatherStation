package com.weather_station.external_apis.open_weather_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class WeatherFromOpenWeather {

    @JsonProperty("coord")
    private Coordinates coordinates;
    @JsonProperty("weather")
    private Weather[] weathers;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("name")
    private String cityName;

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setWeathers(Weather[] weathers) {
        this.weathers = weathers;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Weather[] getWeathers() {
        return weathers;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "WeatherFromOpenWeather{" +
                "\ncoordinates=" + coordinates +
                ", \nweathers=" + Arrays.toString(weathers) +
                ", \nmain=" + main +
                ", \nwind=" + wind +
                ", \nsys=" + sys +
                '}';
    }
}
