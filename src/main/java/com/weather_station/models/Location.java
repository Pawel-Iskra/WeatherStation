package com.weather_station.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cityName;
    private String country;
    private Float longitude;
    private Float latitude;
    @OneToMany
    private List<Weather> weatherList;
}
