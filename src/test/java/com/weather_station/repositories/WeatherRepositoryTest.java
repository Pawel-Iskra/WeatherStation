package com.weather_station.repositories;

import com.weather_station.models.Location;
import com.weather_station.models.Weather;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class WeatherRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    WeatherRepository weatherRepository;

    @Test
    public void when_repo_has_weathers_for_given_city_then_should_return_them_in_correct_order() {
        Location location = new Location();
        testEntityManager.persist(location);
        Weather weather1 = new Weather("2020/11/30", "12:30:00", location);
        Weather weather2 = new Weather("2020/11/30", "11:30:00", location);
        Weather weather3 = new Weather("2020/11/29", "11:30:00", location);
        Weather weather4 = new Weather("2020/10/29", "11:30:00", location);
        List<Weather> weatherList = new ArrayList<>(Arrays.asList(weather1, weather2, weather3, weather4));
        for (int i = (weatherList.size() - 1); i >= 0; i--) {
            testEntityManager.persist(weatherList.get(i));
        }
        assertEquals(weatherList, weatherRepository.findAllByLocationOrderByDateDescHourDesc(location));
    }


}