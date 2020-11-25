package com.weather_station.external_apis.open_weather_api;

import com.weather_station.external_apis.open_weather_api.model.WeatherFromOpenWeather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherApiFetcher {

    @Value("${app.URL_OPENWEATHER1}")
    private String url1;
    @Value("${app.URL_OPENWEATHER2}")
    private String url2;


    public WeatherFromOpenWeather getWeatherFromOpenWeather(String city) {
        return new RestTemplate().getForObject(
                String.format(url1, city), WeatherFromOpenWeather.class);
    }

}
