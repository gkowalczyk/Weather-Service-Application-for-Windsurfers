package com.gkowalczyk.weatherserviceforwindsurfers.controller;

import com.gkowalczyk.weatherserviceforwindsurfers.client.WeatherClient;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataListDto;
import com.gkowalczyk.weatherserviceforwindsurfers.exception.WeatherMapNotFoundException;
import com.gkowalczyk.weatherserviceforwindsurfers.service.WeatherService;
import com.gkowalczyk.weatherserviceforwindsurfers.validator.WeatherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/v1")

public class WeatherController {
    private final WeatherClient weatherClient;
        private final WeatherService weatherService;
    private final WeatherValidator weatherValidator;

    @Autowired
    public WeatherController(WeatherClient weatherClient, WeatherService weatherService, WeatherValidator weatherValidator) {
        this.weatherClient = weatherClient;
        this.weatherService = weatherService;
        this.weatherValidator = weatherValidator;
    }

    @GetMapping("get")

    public ResponseEntity<Map<String, WeatherForecastDataListDto>> findTheBestPlaceToBe(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws WeatherMapNotFoundException {
        return ResponseEntity.ok(weatherValidator.calculateTheBestPlace(weatherService.addWeatherForecastsToMap(date)));
    }
}