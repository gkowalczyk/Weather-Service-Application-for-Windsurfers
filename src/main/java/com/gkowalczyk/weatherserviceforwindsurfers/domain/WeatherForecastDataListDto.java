package com.gkowalczyk.weatherserviceforwindsurfers.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastDataListDto {

    @JsonProperty("high_temp")
    private double high_temp;
    @JsonProperty("low_temp")
    private double low_temp;
    @JsonProperty("wind_spd")
    private double wind_spd;
    @JsonProperty("datetime")
    private String datetime;


}
