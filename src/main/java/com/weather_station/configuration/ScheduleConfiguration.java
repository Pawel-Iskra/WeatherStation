package com.weather_station.configuration;

import com.weather_station.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Configuration
@EnableScheduling
public class ScheduleConfiguration {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private final WeatherService weatherService;
    private final String[] cityList = {"Szczecin", "Warszawa", "Katowice", "Kraków",
            "Wrocław", "Łódź", "Poznań", "Gdańsk", "Gdynia", "Toruń"};

    @Autowired
    public ScheduleConfiguration(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Scheduled(cron = "${weatherForCityList}")
    public void getWeatherForCityListRepetitively() {
        logger.info("start of scheduled method getWeatherForCityListRepetitively at: " + LocalDateTime.now());
        for (String cityName : cityList) {
            weatherService.getCurrentWeatherForCity(cityName);
        }
        logger.info("end of scheduled method getWeatherForCityListRepetitively at: " + LocalDateTime.now());
    }

}
