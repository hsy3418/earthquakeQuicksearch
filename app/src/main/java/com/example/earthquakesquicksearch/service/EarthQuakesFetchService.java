package com.example.earthquakesquicksearch.service;

import com.example.earthquakesquicksearch.pojo.EarthquakeResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface EarthQuakesFetchService {

    @GET("/?format=geojson&starttime=2014-01-01&endtime=2014-01-02&minmagnitude=5")
    Call<EarthquakeResponse> getEarthQuakeResponse();
}
