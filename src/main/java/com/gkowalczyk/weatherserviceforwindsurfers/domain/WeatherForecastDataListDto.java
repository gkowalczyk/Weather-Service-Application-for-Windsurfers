package com.gkowalczyk.weatherserviceforwindsurfers.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherForecastDataListDto {

    @JsonProperty("maxTemperature")
    private String maxTemperature;
    @JsonProperty("minTemperature")
    private String minTemperature;
    @JsonProperty("windSpeed")
    private String windSpeed;
}
