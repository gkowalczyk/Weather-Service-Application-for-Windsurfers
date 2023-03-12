package com.gkowalczyk.weatherserviceforwindsurfers.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecastDataList {

    private double high_temp;
    private double low_temp;
    private double wind_spd;
    private String datatime;
}
