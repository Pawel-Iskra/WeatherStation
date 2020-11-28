package com.weather_station.services;

import com.weather_station.dtos.LocationDto;
import com.weather_station.models.Location;
import com.weather_station.repositories.LocationRepository;
import com.weather_station.transformations.LocationTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {


    private final LocationRepository locationRepository;
    private final LocationTransformer locationTransformer;

    @Autowired
    public LocationService(LocationRepository locationRepository, LocationTransformer locationTransformer) {
        this.locationRepository = locationRepository;
        this.locationTransformer = locationTransformer;
    }


    public List<LocationDto> getAllCitiesFromDb() {
        List<LocationDto> locationsDto = new ArrayList<>();
        List<Location> locations = locationRepository.findAllByOrderByCountryAscCityNameAsc();
        for (Location location : locations) {
            locationsDto.add(locationTransformer.getLocationDtoFromLocationEntity(location));
        }
        return locationsDto;
    }

}
