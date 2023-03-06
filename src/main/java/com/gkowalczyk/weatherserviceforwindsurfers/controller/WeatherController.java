package com.gkowalczyk.weatherserviceforwindsurfers.controller;

import com.gkowalczyk.weatherserviceforwindsurfers.client.Response;
import com.gkowalczyk.weatherserviceforwindsurfers.client.WeatherClient;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecast;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataList;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataListDto;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
//@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/v1")
public class WeatherController {
    private final WeatherClient weatherClient;
    //private final WeatherMapper weatherMapper;


    public WeatherController(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;

    }
    @GetMapping("get")

    public ResponseEntity<List<WeatherForecastDataListDto>> getWeatherForecast() {
      // List<WeatherForecastDataList> list = weatherMapper.mapToBoard(weatherClient.getWeatherForecastDto());
        //return ResponseEntity.ok(weatherMapper.mapToBoardDto(list));
        return ResponseEntity.ok(weatherClient.getWeatherForecastDto());

    }
}
