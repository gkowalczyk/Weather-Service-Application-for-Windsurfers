package com.gkowalczyk.weatherserviceforwindsurfers.database;

import java.util.*;

public class DataBase implements CityInterface {

    private final static List<String> locationSet = new ArrayList<>();

    static {
        locationSet.add(("Jastarnia"));
        locationSet.add(("Bridgetown"));
        locationSet.add(("Fortaleza"));
        locationSet.add(("Pissouri"));
        locationSet.add(("Le Morne"));
        //...
    }

    @Override
    public List<String> getLocation() {
        return new ArrayList<>(locationSet);
    }
}
