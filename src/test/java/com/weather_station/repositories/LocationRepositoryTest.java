package com.weather_station.repositories;

import com.weather_station.models.Location;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void when_db_is_empty_repo_should_return_empty_list() {
        assertTrue(locationRepository.findAllByOrderByCountryAscCityNameAsc().isEmpty());
    }

    @Test
    public void when_there_are_7_cities_in_db_repo_should_return_list_of_7_elements() {
        for (int i = 0; i < 7; i++) {
            testEntityManager.persist(new Location());
        }
        assertEquals(7, locationRepository.findAllByOrderByCountryAscCityNameAsc().size());
    }

    @Test
    public void when_there_are_cities_in_db_repo_should_return_them_in_correct_order() {
        Location szczecin = new Location("Szczecin", "PL");
        Location warszawa = new Location("Warszawa", "PL");
        Location praga = new Location("Praga", "CZ");
        Location brno = new Location("Brno", "CZ");
        List<Location> cities = new ArrayList<>(Arrays.asList(brno, praga, szczecin, warszawa));
        testEntityManager.persist(szczecin);
        testEntityManager.persist(warszawa);
        testEntityManager.persist(praga);
        testEntityManager.persist(brno);
        assertEquals(cities, locationRepository.findAllByOrderByCountryAscCityNameAsc());
    }
}