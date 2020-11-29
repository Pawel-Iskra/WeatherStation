package com.weather_station.transformations;

import com.weather_station.dtos.WeatherDto;
import com.weather_station.dtos.WeatherHistoryDto;
import com.weather_station.external_apis.open_weather_api.model.WeatherFromOpenWeather;
import com.weather_station.models.Weather;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class WeatherTransformer {

    public WeatherDto getWeatherDtoFromOpenWeather(WeatherFromOpenWeather fromOpenWeather) {
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

    public Weather getWeatherEntityFromWeatherDto(WeatherDto weatherDto) {
        Weather weather = new Weather();
        weather.setDate(weatherDto.getDate());
        weather.setHour(weatherDto.getHour());
        weather.setMainWeatherType(weatherDto.getMainWeatherType());
        weather.setWeatherDescription(weatherDto.getWeatherDescription());
        weather.setTemperature(weatherDto.getTemperature());
        weather.setTemperatureSensed(weatherDto.getTemperatureSensed());
        weather.setPressure(weatherDto.getPressure());
        weather.setHumidity(weatherDto.getHumidity());
        weather.setWindSpeed(weatherDto.getWindSpeed());
        weather.setWindDegrees(weatherDto.getWindDegrees());
        return weather;
    }

    public WeatherHistoryDto getWeatherHistoryDtoFromWeatherEntity(Weather weather) {
        WeatherHistoryDto weatherHistoryDto = new WeatherHistoryDto();
        weatherHistoryDto.setDate(weather.getDate());
        weatherHistoryDto.setHour(weather.getHour());
        weatherHistoryDto.setMainWeatherType(weather.getMainWeatherType());
        weatherHistoryDto.setWeatherDescription(weather.getWeatherDescription());
        weatherHistoryDto.setTemperature(weather.getTemperature());
        weatherHistoryDto.setTemperatureSensed(weather.getTemperatureSensed());
        weatherHistoryDto.setPressure(weather.getPressure());
        weatherHistoryDto.setHumidity(weather.getHumidity());
        weatherHistoryDto.setWindSpeed(weather.getWindSpeed());
        weatherHistoryDto.setWindDegrees(weather.getWindDegrees());
        return weatherHistoryDto;
    }
}
