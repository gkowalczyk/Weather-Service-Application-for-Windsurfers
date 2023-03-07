package com.gkowalczyk.weatherserviceforwindsurfers.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class Location {
    private String name;
    private int temperature;
    private int windSpeed;
}
