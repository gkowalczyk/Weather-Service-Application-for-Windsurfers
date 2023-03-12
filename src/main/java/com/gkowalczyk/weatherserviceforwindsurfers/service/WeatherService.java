package com.gkowalczyk.weatherserviceforwindsurfers.service;

import com.gkowalczyk.weatherserviceforwindsurfers.client.WeatherClient;
import com.gkowalczyk.weatherserviceforwindsurfers.database.CityInterface;
import com.gkowalczyk.weatherserviceforwindsurfers.database.DataBase;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private final WeatherClient weatherClient;
    private CityInterface cityInterface = new DataBase();


    @Autowired
    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

   
    public Map<String, WeatherForecastDataListDto> addWeatherForecastsToMap(LocalDate date) {
        List<String> locations = new ArrayList<>(cityInterface.getLocation());
        Map<String, List<WeatherForecastDataListDto>> weatherMap = new HashMap<>();

        for (int i = 0; i < locations.size(); i++) {
            weatherMap.put(locations.get(i), weatherClient.getWeatherForecastDto(locations.get(i)).getData());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String formattedString = date.format(formatter);

        Map<String, WeatherForecastDataListDto> finalMap = new HashMap<>();

        for (Map.Entry<String, List<WeatherForecastDataListDto>> map : weatherMap.entrySet()) {
            List<WeatherForecastDataListDto> findWeathersForOneDay = map.getValue().stream()
                    .filter(y -> y.getDatetime().equals(formattedString))
                    .collect(Collectors.toList());
            finalMap.put(map.getKey(), findWeathersForOneDay.get(0));
        }
            return finalMap;
        }
    }


