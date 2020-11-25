package com.weather_station.external_apis.open_weather_api;

import com.weather_station.external_apis.open_weather_api.model.WeatherFromOpenWeather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherApiFetcher {

    @Value("${app.URL_OPENWEATHER}")
    private String url;

    public WeatherFromOpenWeather getWeatherFromOpenWeather(String city) {
        return new RestTemplate().getForObject(
                String.format(url, city), WeatherFromOpenWeather.class);
    }

}
