package com.example.earthquakesquicksearch.presenter;

import com.example.earthquakesquicksearch.pojo.EarthquakeResponse;

public interface IsearchPreseter {

    void fetchEarthquakesData(String format,String startTime,String endTime, String minMagnitude,String orderBy);

    void fetchSuccess(EarthquakeResponse earthquakeResponse);

    //TODO create a failResponse
    void fetchFail();
}
