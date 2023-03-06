package com.gkowalczyk.weatherserviceforwindsurfers.controller;

import com.gkowalczyk.weatherserviceforwindsurfers.client.WeatherClient;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecast;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDto;
import com.gkowalczyk.weatherserviceforwindsurfers.mapper.WeatherMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")

public class WeatherController {
    private final WeatherClient weatherClient;
    private final WeatherMapper weatherMapper;


    public WeatherController(WeatherClient weatherClient, WeatherMapper weatherMapper) {
        this.weatherClient = weatherClient;
        this.weatherMapper = weatherMapper;
    }
    @GetMapping("get")

    public ResponseEntity<WeatherForecastDto> getWeatherForecast() {
        WeatherForecast weatherForecast = weatherMapper.mapToWeatherForecast(weatherClient.getWeatherForecastDto());
            return ResponseEntity.ok(weatherMapper.mapToWeatherForecastDto(weatherForecast));
    }
}
