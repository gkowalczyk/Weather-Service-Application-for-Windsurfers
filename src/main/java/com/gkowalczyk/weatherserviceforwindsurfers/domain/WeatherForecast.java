package com.gkowalczyk.weatherserviceforwindsurfers.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecast {

    private String city_name;
    private List<WeatherForecastDataList> data;
}
