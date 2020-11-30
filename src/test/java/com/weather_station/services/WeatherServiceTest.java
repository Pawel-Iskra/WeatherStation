package com.weather_station.services;


import com.weather_station.dtos.WeatherDto;
import com.weather_station.external_apis.open_weather_api.OpenWeatherApiFetcher;
import com.weather_station.external_apis.open_weather_api.model.*;
import com.weather_station.models.Weather;
import com.weather_station.repositories.LocationRepository;
import com.weather_station.repositories.WeatherRepository;
import com.weather_station.transformations.WeatherTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class WeatherServiceTest {

    @TestConfiguration
    static class WeatherServiceTestConfiguration {
        @Bean
        public WeatherService weatherService(WeatherRepository weatherRepository, LocationRepository locationRepository,
                                             OpenWeatherApiFetcher openWeatherApiFetcher, WeatherTransformer weatherTransformer) {
            return new WeatherService(weatherRepository, locationRepository, openWeatherApiFetcher, weatherTransformer);
        }
    }

    @MockBean
    private WeatherRepository weatherRepository;
    @MockBean
    private LocationRepository locationRepository;
    @MockBean
    private OpenWeatherApiFetcher openWeatherApiFetcher;
    @MockBean
    private WeatherTransformer weatherTransformer;

    @Autowired
    private WeatherService weatherService;


    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    public void when_given_cityName_is_empty_or_blank_IllegalArgumentException_should_be_thrown(String cityName) {
        assertThrows(IllegalArgumentException.class,
                () -> weatherService.getCurrentWeatherForCity(cityName));
    }

    @ParameterizedTest
    @NullSource
    public void when_given_cityName_is_null_IllegalArgumentException_should_be_thrown(String cityName) {
        assertThrows(IllegalArgumentException.class,
                () -> weatherService.getCurrentWeatherForCity(cityName));
    }

    @Test
    public void when_given_cityName_is_OK_then_getWeatherFromOpenWeather_from_openWeatherApiFetcher_should_be_called() {
        String cityName = "validCityName";
        try {
            weatherService.getCurrentWeatherForCity(cityName);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        Mockito.verify(openWeatherApiFetcher).getWeatherFromOpenWeather(cityName);
    }

    @Test
    public void when_given_cityName_is_blank_then_method_getWeatherHistoryForCity_should_throw_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> weatherService.getWeatherHistoryForCity("   "));
    }

    @Test
    public void when_given_cityName_is_correct_then_method_getWeatherHistoryForCity_should_call_findByCityName_from_locationRepository() {
        String cityName = "validCityName";
        try {
            weatherService.getWeatherHistoryForCity(cityName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        Mockito.verify(locationRepository).findByCityName(cityName);
    }

}