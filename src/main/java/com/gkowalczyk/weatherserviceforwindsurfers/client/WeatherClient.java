package com.gkowalczyk.weatherserviceforwindsurfers.client;

import ch.qos.logback.classic.Logger;
import com.gkowalczyk.weatherserviceforwindsurfers.config.WeatherBitConfig;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecast;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDataListDto;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDto;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
@EqualsAndHashCode
public class WeatherClient {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(WeatherClient.class);
    private final RestTemplate restTemplate;
    private final WeatherBitConfig weatherBitConfig;




    //@EventListener(ApplicationReadyEvent.class)
    public List<WeatherForecastDataListDto> getWeatherForecastDto() {



//https://api.weatherbit.io/v2.0/forecast/daily?key=9c8870c21a7444f5ad496d7c0eb61456&city=Jastarnia&days=1
//https://api.weatherbit.io/v2.0/forecast/daily?city=Jastarnia&days=1&key=9c8870c21a7444f5ad496d7c0eb61456
        URI url = UriComponentsBuilder.
                fromHttpUrl(weatherBitConfig.getWeatherApiEndpoint())
                .queryParam("key", "9c8870c21a7444f5ad496d7c0eb61456")
                .queryParam("city", "Jastarnia")
                .queryParam("days", "1")
                // .queryParam("key", "9c8870c21a7444f5ad496d7c0eb61456")
                .build()
                .encode()
                .toUri();

        try {

            WeatherForecastDto[] boardsResponse = restTemplate.getForObject(url, WeatherForecastDto[].class);
            List<WeatherForecastDataListDto> list = (List<WeatherForecastDataListDto>) Arrays.stream(boardsResponse);
            return ofNullable(list)
                    //.map(Arrays::asList)
                    .orElse(Collections.emptyList());
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}





