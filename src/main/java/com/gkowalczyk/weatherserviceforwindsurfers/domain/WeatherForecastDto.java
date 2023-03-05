package com.gkowalczyk.weatherserviceforwindsurfers.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastDto {
     @JsonProperty("city_name")
      private String city_name;
    @JsonProperty("data")
    private List<WeatherForecastDataListDto> data;
}
