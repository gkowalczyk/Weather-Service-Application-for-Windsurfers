package com.gkowalczyk.weatherserviceforwindsurfers.service;

import com.gkowalczyk.weatherserviceforwindsurfers.client.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherClient weatherClient;

    @Autowired
    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

   /* public Location findTheBestCondition(LocalDate date) {
        Map<String, Object> map = DataBase.getLocation().stream()
                .collect(Collectors.toMap(Location::getName, value-> weatherClient.getWeatherForecastDto(date, new Location(value.getName()))));
        return new Location("");

    }*/
}
