package com.gkowalczyk.weatherserviceforwindsurfers.client;

import ch.qos.logback.classic.Logger;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.gkowalczyk.weatherserviceforwindsurfers.config.WeatherBitConfig;
import com.gkowalczyk.weatherserviceforwindsurfers.database.DataBase;
import com.gkowalczyk.weatherserviceforwindsurfers.database.Location;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataListDto;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDto;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.webresources.EmptyResource;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
@EqualsAndHashCode
public class WeatherClient {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(WeatherClient.class);
    private final RestTemplate restTemplate;
    private final WeatherBitConfig weatherBitConfig;


    public WeatherForecastDto getWeatherForecastDto(String location) {

        URI url = UriComponentsBuilder.
                fromHttpUrl(weatherBitConfig.getWeatherApiEndpoint())
                .queryParam("key", weatherBitConfig.getWeatherAppKey())
                .queryParam("city", location)
                // .queryParam("days", localDate.getDayOfMonth())
                // .queryParam("key", "9c8870c21a7444f5ad496d7c0eb61456")
                .build()
                .encode()
                .toUri();
        try {
            WeatherForecastDto forecast = restTemplate.getForObject(url, WeatherForecastDto.class);
            return ofNullable(forecast)
                    .orElseThrow();
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new WeatherForecastDto();
        }

    }

    public Map<String, WeatherForecastDto> addWeatherForecastToMap(LocalDate date, Map<String, WeatherForecastDto> weatherMap) {
        List<String> locations = new ArrayList<>(DataBase.getLocation());
        List<WeatherForecastDataListDto> weatherForecastDataListDtoList = new ArrayList<>();

        for (int i = 0; i < locations.size(); i++) {
                        int finalI1 = i;
            weatherMap.put(locations.get(i), getWeatherForecastDto(locations.get(finalI1)));
        }
        return weatherMap;
    }
    }




