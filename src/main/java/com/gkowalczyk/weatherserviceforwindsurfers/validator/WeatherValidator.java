package com.gkowalczyk.weatherserviceforwindsurfers.validator;

import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataListDto;
import com.gkowalczyk.weatherserviceforwindsurfers.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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

        public BigDecimal calculateCoefficientCondition(Map<String, WeatherForecastDataListDto> map) {

        return BigDecimal.ZERO;
        }


    }


