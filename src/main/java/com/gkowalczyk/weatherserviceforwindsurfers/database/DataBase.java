package com.gkowalczyk.weatherserviceforwindsurfers.database;

import java.util.HashSet;
import java.util.Set;

public class DataBase {

    private final static Set<String> locationSet = new HashSet<>();

    static {
        locationSet.add(("Jastarnia"));
        locationSet.add(("Bridgetown"));
        //...

    }
    public static Set<String> getLocation() {
        return new HashSet<>(locationSet);
    }
}
