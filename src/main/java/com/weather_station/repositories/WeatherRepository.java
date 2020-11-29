package com.weather_station.repositories;

import com.weather_station.models.Location;
import com.weather_station.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    List<Weather> findAllByLocationOrderByDateDesc(Location location);
}
