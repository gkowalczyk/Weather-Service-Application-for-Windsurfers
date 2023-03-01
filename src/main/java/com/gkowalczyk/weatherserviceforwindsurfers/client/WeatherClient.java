package com.gkowalczyk.weatherserviceforwindsurfers.client;

import ch.qos.logback.classic.Logger;
import com.gkowalczyk.weatherserviceforwindsurfers.config.WeatherBitConfig;
import com.gkowalczyk.weatherserviceforwindsurfers.domain.WeatherForecastDto;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@EqualsAndHashCode
public class WeatherClient {

    private static final Logger logger= (Logger) LoggerFactory.getLogger(WeatherClient.class);
    private final RestTemplate restTemplate;
    private final WeatherBitConfig weatherBitConfig;

public WeatherForecastDto weatherForecastDto() {
        return null;
}
}
