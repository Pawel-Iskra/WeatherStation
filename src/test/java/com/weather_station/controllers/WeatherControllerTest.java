package com.weather_station.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @Autowired
    WeatherController weatherController;

    @Autowired
    MockMvc mockMvc;

//    @Test
//    public void when_request_with_valid_cityName_then_status_OK_should_be_returned() throws Exception {
//        mockMvc.perform(get("/weather/city?name=Warsaw")
//                .contentType("application/json"))
//                .andExpect(status().isOk());
//    }

}