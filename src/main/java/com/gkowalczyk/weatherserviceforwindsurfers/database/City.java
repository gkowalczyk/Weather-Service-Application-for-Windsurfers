package com.gkowalczyk.weatherserviceforwindsurfers.database;

import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataList;

import java.util.Map;

public interface City {
    Map<String, String> weatherMap();
}
