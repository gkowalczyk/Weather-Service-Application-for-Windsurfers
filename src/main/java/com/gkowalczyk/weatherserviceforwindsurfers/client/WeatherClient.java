package com.gkowalczyk.weatherserviceforwindsurfers.client;

import ch.qos.logback.classic.Logger;
import com.gkowalczyk.weatherserviceforwindsurfers.config.WeatherBitConfig;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDto;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
}



