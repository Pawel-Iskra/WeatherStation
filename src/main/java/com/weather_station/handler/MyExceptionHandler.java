package com.weather_station.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class MyExceptionHandler {


    // HttpClientErrorException$NotFound
    // handling the exception thrown by openWeatherApiFetcher when given city name
    // is not found by this Api
    @ExceptionHandler(value = HttpClientErrorException.class)
    public ResponseEntity<Object> httpClientErrorException(HttpClientErrorException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
