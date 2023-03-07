package com.gkowalczyk.weatherserviceforwindsurfers.controller;

import com.gkowalczyk.weatherserviceforwindsurfers.client.WeatherClient;
import com.gkowalczyk.weatherserviceforwindsurfers.database.Location;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDto;
import com.gkowalczyk.weatherserviceforwindsurfers.mapper.WeatherMapper;
import com.gkowalczyk.weatherserviceforwindsurfers.service.WeatherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")

public class WeatherController {
    private final WeatherClient weatherClient;
    private final WeatherMapper weatherMapper;
    private final WeatherService weatherService;

    public WeatherController(WeatherClient weatherClient, WeatherMapper weatherMapper, WeatherService weatherService) {
        this.weatherClient = weatherClient;
        this.weatherMapper = weatherMapper;
        this.weatherService = weatherService;
    }
  //  @GetMapping("get")

   // public ResponseEntity<WeatherForecastDto> getWeatherForecast(@RequestParam("location") String location) {

        //WeatherForecast weatherForecast = weatherMapper.mapToWeatherForecast(weatherClient.getWeatherForecastDto(location));
      // WeatherForecastDataListDto weatherForecast = weatherClient.getWeatherForecastDto(location, date);

         //   return ResponseEntity.ok(weatherClient.getWeatherForecastDto(location));
    //}
    @GetMapping("get")
    public Map<String, WeatherForecastDto> findTheBestPlaceToBe(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        final Map<String, WeatherForecastDto> mapOfCandidateLocations = new HashMap<>();
        return weatherClient.addWeatherForecastToMap(date,mapOfCandidateLocations);
        //return weatherService.findTheBestCondition(date);
    }
}