package com.weather_station.models;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String hour;
    private String mainWeatherType;
    private String weatherDescription;
    private Float temperature;
    private Float temperatureSensed;
    private Integer pressure;
    private Integer humidity;
    private Float windSpeed;
    private Integer windDegrees;
    @ManyToOne
    private Location location;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setMainWeatherType(String mainWeatherType) {
        this.mainWeatherType = mainWeatherType;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public void setTemperatureSensed(Float temperatureSensed) {
        this.temperatureSensed = temperatureSensed;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindDegrees(Integer windDegrees) {
        this.windDegrees = windDegrees;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public String getMainWeatherType() {
        return mainWeatherType;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

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

    public Float getWindSpeed() {
        return windSpeed;
    }

    public Integer getWindDegrees() {
        return windDegrees;
    }

    public Location getLocation() {
        return location;
    }
}
