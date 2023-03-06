package com.gkowalczyk.weatherserviceforwindsurfers.config;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class WeatherBitConfig {
    @Value("${weather.api.endpoint.prod}")
    private String weatherApiEndpoint;
    @Value("${weather.app.key}")
    private String weatherAppKey;
}
