package com.weather_station.transformations;

import com.weather_station.dtos.WeatherDto;
import com.weather_station.external_apis.open_weather_api.model.WeatherFromOpenWeather;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class WeatherTransformer {

    public WeatherDto fromOpenWeatherToWeatherDto(WeatherFromOpenWeather fromOpenWeather) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setCityName(fromOpenWeather.getCityName());
        weatherDto.setCountry(fromOpenWeather.getSys().getCountry());
        weatherDto.setLongitude(fromOpenWeather.getCoordinates().getLongitude());
        weatherDto.setLatitude(fromOpenWeather.getCoordinates().getLatitude());

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        weatherDto.setDate(dateFormat.format(now));
        weatherDto.setHour(hourFormat.format(now));

        weatherDto.setMainWeatherType(fromOpenWeather.getWeathers()[0].getMainWeatherType());
        weatherDto.setWeatherDescription(fromOpenWeather.getWeathers()[0].getWeatherDescription());
        weatherDto.setTemperature(fromOpenWeather.getMain().getTemperature());
        weatherDto.setTemperatureSensed(fromOpenWeather.getMain().getTemperatureSensed());
        weatherDto.setPressure(fromOpenWeather.getMain().getPressure());
        weatherDto.setHumidity(fromOpenWeather.getMain().getHumidity());
        weatherDto.setWindSpeed(fromOpenWeather.getWind().getSpeed());
        weatherDto.setWindDegrees(fromOpenWeather.getWind().getDegrees());

        return weatherDto;
    }
}
