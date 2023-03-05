package com.gkowalczyk.weatherserviceforwindsurfers.mapper;

import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecast;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataList;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataListDto;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherMapper {


    public List<WeatherForecast> mapToBoard(final List<WeatherForecastDto> weatherBoardDto) {
        return weatherBoardDto.stream()
                .map(weather -> new WeatherForecast(weather.getCity_name(), mapToList(weather.getData())))
                .collect(Collectors.toList());

    }

    public List<WeatherForecastDataList> mapToList(final List<WeatherForecastDataListDto> weatherForecastDataListDtoList) {
        return weatherForecastDataListDtoList.stream()
                .map(list -> new WeatherForecastDataList(list.getHigh_temp(), list.getLow_temp(), list.getWind_spd()))
                .collect(Collectors.toList());
    }
    public List<WeatherForecastDto> mapToBoardDto(final List<WeatherForecast> weatherBoard) {
        return weatherBoard.stream()
                .map(weather -> new WeatherForecastDto(weather.getCity_name(), mapToListDto(weather.getData())))
                .collect(Collectors.toList());

    }

    public List<WeatherForecastDataListDto> mapToListDto(final List<WeatherForecastDataList> weatherForecastDataListList) {
        return weatherForecastDataListList.stream()
                .map(list -> new WeatherForecastDataListDto(list.getHigh_temp(), list.getLow_temp(), list.getWind_spd()))
                .collect(Collectors.toList());
    }


}
