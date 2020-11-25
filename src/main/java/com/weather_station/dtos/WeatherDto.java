package com.weather_station.dtos;

public class WeatherDto {

    private String cityName;
    private String country;
    private Float longitude;
    private Float latitude;
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

    public String getCityName() {
        return cityName;
    }

    public String getCountry() {
        return country;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
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

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
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

    @Override
    public String toString() {
        return "WeatherDto{" +
                "cityName='" + cityName + '\'' +
                ", country='" + country + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", mainWeatherType='" + mainWeatherType + '\'' +
                ", weatherDescription='" + weatherDescription + '\'' +
                ", temperature=" + temperature +
                ", temperatureSensed=" + temperatureSensed +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", windDegrees=" + windDegrees +
                '}';
    }
}
