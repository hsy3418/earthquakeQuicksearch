package com.example.earthquakesquicksearch.presenter;

import com.example.earthquakesquicksearch.pojo.EarthquakeResponse;

public interface IsearchPreseter {

    void fetchEarthquakesData(String url);

    void fetchSuccess(EarthquakeResponse earthquakeResponse);

    //TODO create a failResponse
    void fetchFail();
}
