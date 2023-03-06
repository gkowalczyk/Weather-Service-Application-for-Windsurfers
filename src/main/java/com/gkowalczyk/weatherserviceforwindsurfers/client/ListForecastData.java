package com.gkowalczyk.weatherserviceforwindsurfers.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataListDto;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
class ListForecastData {
	@JsonProperty("data")
	public List<WeatherForecastDataListDto> data;
}
