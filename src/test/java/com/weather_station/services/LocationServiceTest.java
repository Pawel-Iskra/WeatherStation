package com.weather_station.services;

import com.weather_station.dtos.LocationDto;
import com.weather_station.external_apis.open_weather_api.OpenWeatherApiFetcher;
import com.weather_station.models.Location;
import com.weather_station.repositories.LocationRepository;
import com.weather_station.repositories.WeatherRepository;
import com.weather_station.transformations.LocationTransformer;
import com.weather_station.transformations.WeatherTransformer;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class LocationServiceTest {

    @TestConfiguration
    static class WeatherServiceTestConfiguration {
        @Bean
        public LocationService locationService(LocationRepository locationRepository, LocationTransformer locationTransformer) {
            return new LocationService(locationRepository, locationTransformer);
        }
    }

    @MockBean
    private LocationRepository locationRepository;
    @MockBean
    private LocationTransformer locationTransformer;

    @Autowired
    LocationService locationService;


    @Test
    public void when_getAllCitiesFromDb_is_called_then_method_findAllByOrderByCountryAscCityNameAsc_from_locRep_should_be_called() {
        locationService.getAllCitiesFromDb();
        Mockito.verify(locationRepository).findAllByOrderByCountryAscCityNameAsc();
    }


}