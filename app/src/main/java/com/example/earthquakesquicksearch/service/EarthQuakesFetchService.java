package com.example.earthquakesquicksearch.service;

import com.example.earthquakesquicksearch.pojo.EarthquakeResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EarthQuakesFetchService {

    @GET("1/query")
    Call<EarthquakeResponse> getEarthQuakeResponse(@Query("format") String format,@Query("starttime") String startTime,
                                                   @Query("endtime") String endtime,@Query("minmagnitude") String minmagnitude);
}
