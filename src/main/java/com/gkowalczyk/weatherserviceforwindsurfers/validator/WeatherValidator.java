package com.gkowalczyk.weatherserviceforwindsurfers.validator;

import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataListDto;
import com.gkowalczyk.weatherserviceforwindsurfers.exception.WeatherMapNotFoundException;
import com.gkowalczyk.weatherserviceforwindsurfers.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class WeatherValidator {
    private static final double MINIMUM_WIND_SPEED = 5;
    private static final double MAXIMUM_WIND_SPEED = 18;
    private static final double MINIMUM_TEMPERATURE = 5;
    private static final double MAXIMUM_TEMPERATURE = 35;

    private final WeatherService weatherService;

    @Autowired
    public WeatherValidator(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public Map<String, WeatherForecastDataListDto> calculateWindAndTemperatureCondition(Map<String, WeatherForecastDataListDto> weatherMap) {


        return weatherMap.entrySet().stream()
                .filter(val -> val.getValue().getWind_spd() > MINIMUM_WIND_SPEED && val.getValue().getWind_spd() < MAXIMUM_WIND_SPEED)
                .filter(val -> val.getValue().getLow_temp() > MINIMUM_TEMPERATURE && val.getValue().getHigh_temp() < MAXIMUM_TEMPERATURE)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, Double> calculateCoefficientCondition(Map<String, WeatherForecastDataListDto> map) {

        Map<String, Double> finalMap = new HashMap<>();
        for (Map.Entry<String, WeatherForecastDataListDto> calculateCoefficientConditionMap : map.entrySet()) {

            double windSpeed = calculateCoefficientConditionMap.getValue().getWind_spd();
            double maxTemp = calculateCoefficientConditionMap.getValue().getHigh_temp();
            double minTemp = calculateCoefficientConditionMap.getValue().getLow_temp();
            double averageTemp = (maxTemp + minTemp) / 2;
            double result = windSpeed * 3 + averageTemp;
            finalMap.put(calculateCoefficientConditionMap.getKey(), result);
        }
        return finalMap;
    }

    public Map<String, WeatherForecastDataListDto> calculateTheBestPlace(Map<String, WeatherForecastDataListDto> weatherMap) throws WeatherMapNotFoundException {

        Map<String, WeatherForecastDataListDto> calculateWindAndTemperatureConditionMap = calculateWindAndTemperatureCondition(weatherMap);
        Map<String, Double> calculateCoefficientConditionMap = calculateCoefficientCondition(calculateWindAndTemperatureConditionMap);
        Map.Entry<String, Double> maxValue = calculateCoefficientConditionMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).orElseThrow(() -> (new WeatherMapNotFoundException("")));
        Map<String, WeatherForecastDataListDto> mapOfBestLocation = calculateWindAndTemperatureConditionMap.entrySet()
                .stream()
                .filter(o -> o.getKey()
                        .equals(maxValue.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return calculateCoefficientConditionMap.size() > 1 ? mapOfBestLocation : new HashMap<>();
    }
}



