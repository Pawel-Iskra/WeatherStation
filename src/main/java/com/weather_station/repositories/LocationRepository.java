package com.weather_station.repositories;

import com.weather_station.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByCityName(String name);
}
