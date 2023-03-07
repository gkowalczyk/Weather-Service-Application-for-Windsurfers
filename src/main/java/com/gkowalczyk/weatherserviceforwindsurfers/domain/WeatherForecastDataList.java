package com.gkowalczyk.weatherserviceforwindsurfers.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecastDataList {

    private double high_temp;
    private double low_temp;
    private double wind_spd;
    private LocalDate datatime;
}
