package com.example.earthquakesquicksearch.model;

import com.example.earthquakesquicksearch.pojo.EarthquakeResponse;
import com.example.earthquakesquicksearch.presenter.IsearchPreseter;
import com.example.earthquakesquicksearch.service.EarthQuakesFetchService;
import com.example.earthquakesquicksearch.service.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EarthquakeSearchModel implements IsearchModel {

    private IsearchPreseter isearchPreseter;

    public EarthquakeSearchModel(IsearchPreseter isearchPreseter) {
        this.isearchPreseter = isearchPreseter;
    }

    @Override
    public void search(String format,String startTime,String endTime, String minMagnitude,String orderby) {
        //TODO this will trigger a http call to get the response, could check okhttp3,
        //TODO need to create a callback method, and return results in callback method
        EarthQuakesFetchService service = RetrofitClientInstance.getClient().create(EarthQuakesFetchService.class);
        Call<EarthquakeResponse> call = service.getEarthQuakeResponse(format,startTime,endTime,minMagnitude,orderby);
        call.enqueue(new Callback<EarthquakeResponse>() {

            @Override
            public void onResponse(Call<EarthquakeResponse> call, Response<EarthquakeResponse> response) {
                isearchPreseter.fetchSuccess(response.body());
            }

            @Override
            public void onFailure(Call<EarthquakeResponse> call, Throwable t) {
                isearchPreseter.fetchFail();

            }
        });
    }


}
