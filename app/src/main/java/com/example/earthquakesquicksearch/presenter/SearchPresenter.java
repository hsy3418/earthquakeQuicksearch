package com.example.earthquakesquicksearch.presenter;

import com.example.earthquakesquicksearch.model.EarthquakeSearchModel;
import com.example.earthquakesquicksearch.model.IsearchModel;
import com.example.earthquakesquicksearch.pojo.EarthquakeResponse;
import com.example.earthquakesquicksearch.view.ISearchView;

public class SearchPresenter implements IsearchPreseter {
    private ISearchView iSearchView;
    private IsearchModel isearchModel;


    public SearchPresenter(ISearchView iSearchView) {
        this.iSearchView = iSearchView;
        this.isearchModel = new EarthquakeSearchModel(this);
    }

    @Override
    public void fetchEarthquakesData(String format,String startTime,String endTime, String minMagnitude) {
        isearchModel.search(format,startTime,endTime,minMagnitude);
    }

    @Override
    public void fetchSuccess(EarthquakeResponse earthquakeResponse) {
        iSearchView.showDetailAcitivty();
    }

    @Override
    public void fetchFail() {
        iSearchView.showFailToast();
    }
}
