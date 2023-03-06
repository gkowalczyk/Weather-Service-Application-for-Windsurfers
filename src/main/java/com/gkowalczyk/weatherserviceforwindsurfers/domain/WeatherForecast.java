package com.gkowalczyk.weatherserviceforwindsurfers.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecast {

    private String city_name;
    private List<WeatherForecastDataList> data;
}
