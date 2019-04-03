package com.example.earthquakesquicksearch.utils;

import com.example.earthquakesquicksearch.pojo.EarthquakeResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Converter {

    private Gson gson;

    public Converter() {
        this.gson=new GsonBuilder().create();

    }

    public EarthquakeResponse getEarthquakeResponse(String jsonResponse){
        EarthquakeResponse earthquakeResponse = gson.fromJson(jsonResponse,EarthquakeResponse.class);
        return earthquakeResponse;
    }
}
