package com.gkowalczyk.weatherserviceforwindsurfers.database;

import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecast;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataList;

import java.util.HashMap;
import java.util.Map;

public class CityPointImpl implements City {
    @Override
    public Map<String, String> weatherMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Jastarna","new WeatherForecast().getCity_name()");
        return map;
    }
}
