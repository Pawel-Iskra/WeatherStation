package com.weather_station.repositories;

import com.weather_station.models.Location;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class LocationRepositoryTest {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void when_city_exist_in_db_then_repo_should_return_this_city() {
        String cityName = "validCityName";
        Location location = new Location();
        location.setCityName(cityName);
        testEntityManager.persist(location);

        assertEquals(location, locationRepository.findByCityName(cityName).get());
    }

    @Test
    public void when_city_does_not_exist_in_db_then_repo_should_return_empty_optional() {
        String cityName = "xyz";
        assertTrue(locationRepository.findByCityName(cityName).isEmpty());
    }
}