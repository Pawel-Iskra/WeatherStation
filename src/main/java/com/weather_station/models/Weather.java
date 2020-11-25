package com.weather_station.models;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String hour;
    private String mainWeatherType;
    private String weatherDescription;
    private Float temperature;
    private Float temperatureSensed;
    private Integer pressure;
    private Integer humidity;
    private Float windSpeed;
    private Integer windDegrees;
    @ManyToOne
    private Location location;


}
