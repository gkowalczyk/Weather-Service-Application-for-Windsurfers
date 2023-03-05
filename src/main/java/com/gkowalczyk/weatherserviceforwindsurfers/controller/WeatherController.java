package com.gkowalczyk.weatherserviceforwindsurfers.controller;

import com.gkowalczyk.weatherserviceforwindsurfers.client.WeatherClient;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecast;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataList;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataListDto;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDto;
import com.gkowalczyk.weatherserviceforwindsurfers.mapper.WeatherMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/v1")
//@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/v1")
public class WeatherController {
    private final WeatherClient weatherClient;
    private final WeatherMapper weatherMapper;


    public WeatherController(WeatherClient weatherClient, WeatherMapper weatherMapper) {
        this.weatherClient = weatherClient;
        this.weatherMapper = weatherMapper;
    }

    @GetMapping

    public ResponseEntity<List<WeatherForecastDto>> getWeatherForecast() {
        List<WeatherForecast> list = weatherMapper.mapToBoard(weatherClient.getWeatherForecastDto());
        return ResponseEntity.ok(weatherMapper.mapToBoardDto(list));
    }
}
