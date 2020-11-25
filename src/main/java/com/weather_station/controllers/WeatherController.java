package com.weather_station.controllers;

import com.weather_station.dtos.WeatherDto;
import com.weather_station.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {


    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/city")
    public ResponseEntity<WeatherDto> getCurrentWeatherForCity(@RequestParam String name) {
        return new ResponseEntity<>(weatherService.getCurrentWeatherForCity(name), HttpStatus.OK);
    }

}
