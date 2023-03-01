package com.gkowalczyk.weatherserviceforwindsurfers.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastDto {
    private List<WeatherForecastDataListDto> list;
}
