package com.weather_station.services;

import com.weather_station.dtos.WeatherDto;
import com.weather_station.external_apis.open_weather_api.OpenWeatherApiFetcher;
import com.weather_station.external_apis.open_weather_api.model.WeatherFromOpenWeather;
import com.weather_station.repositories.WeatherRepository;
import com.weather_station.transformations.WeatherTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {


    private final WeatherRepository weatherRepository;
    private final OpenWeatherApiFetcher openWeatherApiFetcher;
    private final WeatherTransformer weatherTransformer;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, OpenWeatherApiFetcher openWeatherApiFetcher,
                          WeatherTransformer weatherTransformer) {
        this.weatherRepository = weatherRepository;
        this.openWeatherApiFetcher = openWeatherApiFetcher;
        this.weatherTransformer = weatherTransformer;
    }

    public WeatherDto getCurrentWeatherForCity(String city) {
        WeatherFromOpenWeather fromOpenWeather = openWeatherApiFetcher.getWeatherFromOpenWeather(city);

        WeatherDto weatherDto = weatherTransformer.fromOpenWeatherToWeatherDto(fromOpenWeather);

        return weatherDto;
    }
}
