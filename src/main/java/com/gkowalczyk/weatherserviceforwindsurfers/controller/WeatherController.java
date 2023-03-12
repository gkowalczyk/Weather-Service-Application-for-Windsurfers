package com.gkowalczyk.weatherserviceforwindsurfers.controller;

import com.gkowalczyk.weatherserviceforwindsurfers.client.WeatherClient;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataListDto;
import com.gkowalczyk.weatherserviceforwindsurfers.mapper.WeatherMapper;
import com.gkowalczyk.weatherserviceforwindsurfers.service.WeatherService;
import com.gkowalczyk.weatherserviceforwindsurfers.validator.WeatherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1")

public class WeatherController {
    private final WeatherClient weatherClient;
    private final WeatherMapper weatherMapper;
    private final WeatherService weatherService;
    private final WeatherValidator weatherValidator;

    @Autowired
    public WeatherController(WeatherClient weatherClient, WeatherMapper weatherMapper, WeatherService weatherService, WeatherValidator weatherValidator) {
        this.weatherClient = weatherClient;
        this.weatherMapper = weatherMapper;
        this.weatherService = weatherService;
        this.weatherValidator = weatherValidator;
    }

    @GetMapping("get1")
    // public WeatherForecastDataListDto findTheBestPlaceToBe(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
    public Map<String, WeatherForecastDataListDto> findTheBestPlaceToBe(@RequestParam("date") String date, Map<String, WeatherForecastDataListDto> mapOfCandidateLocations ) {
        // final Map<String, WeatherForecastDto> mapOfCandidateLocations = new HashMap<>();
        return weatherValidator.calculateWindAndTemperatureCondition(weatherService.addWeatherForecastsToMap(date));
       // return weatherService.addWeatherForecastsToMap(date);
        //return weatherService.findTheBestCondition(date);
}
}