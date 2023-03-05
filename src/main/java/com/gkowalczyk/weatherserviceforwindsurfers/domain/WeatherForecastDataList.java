package com.gkowalczyk.weatherserviceforwindsurfers.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecastDataList {

    private String high_temp;

    private String low_temp;

    private String wind_spd;
}
