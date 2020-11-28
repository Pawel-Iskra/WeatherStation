package com.weather_station.services;

import com.weather_station.dtos.WeatherDto;
import com.weather_station.external_apis.open_weather_api.OpenWeatherApiFetcher;
import com.weather_station.external_apis.open_weather_api.model.WeatherFromOpenWeather;
import com.weather_station.models.Location;
import com.weather_station.models.Weather;
import com.weather_station.repositories.LocationRepository;
import com.weather_station.repositories.WeatherRepository;
import com.weather_station.transformations.WeatherTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {


    private final WeatherRepository weatherRepository;
    private final LocationRepository locationRepository;
    private final OpenWeatherApiFetcher openWeatherApiFetcher;
    private final WeatherTransformer weatherTransformer;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, LocationRepository locationRepository,
                          OpenWeatherApiFetcher openWeatherApiFetcher, WeatherTransformer weatherTransformer) {
        this.weatherRepository = weatherRepository;
        this.locationRepository = locationRepository;
        this.openWeatherApiFetcher = openWeatherApiFetcher;
        this.weatherTransformer = weatherTransformer;
    }

    public WeatherDto getCurrentWeatherForCity(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException(String.format("given city name=%s is invalid", city));
        }
        WeatherFromOpenWeather fromOpenWeather = openWeatherApiFetcher.getWeatherFromOpenWeather(city);
        WeatherDto weatherDto = weatherTransformer.getWeatherDtoFromOpenWeather(fromOpenWeather);

        // saving location & weather to database
        saveLocationAndWeatherToDb(weatherDto);

        return weatherDto;
    }

    private void saveLocationAndWeatherToDb(WeatherDto weatherDto) {
        Location location = new Location();
        String cityName = weatherDto.getCityName();
        Optional<Location> locationOptional = locationRepository.findByCityName(cityName);
        if (locationOptional.isEmpty()) {
            location = new Location();
            location.setCityName(cityName);
            location.setCountry(weatherDto.getCountry());
            location.setLongitude(weatherDto.getLongitude());
            location.setLatitude(weatherDto.getLatitude());
            locationRepository.save(location);
        } else {
            location = locationOptional.get();
        }
        Weather weather = weatherTransformer.getWeatherEntityFromWeatherDto(weatherDto);
        weather.setLocation(location);
        weatherRepository.save(weather);
    }

}
