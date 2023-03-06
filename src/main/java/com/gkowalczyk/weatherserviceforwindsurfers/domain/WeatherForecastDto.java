package com.gkowalczyk.weatherserviceforwindsurfers.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastDto {

    @JsonProperty("data")
    private List<WeatherForecastDataListDto> data;


}
