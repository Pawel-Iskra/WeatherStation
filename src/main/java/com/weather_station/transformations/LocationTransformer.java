package com.weather_station.transformations;

import com.weather_station.dtos.LocationDto;
import com.weather_station.models.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationTransformer {

    public LocationDto getLocationDtoFromLocationEntity(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setCityName(location.getCityName());
        locationDto.setCountry(location.getCountry());
        return locationDto;
    }
}
