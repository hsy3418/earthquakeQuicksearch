package com.example.earthquakesquicksearch.presenter;

import com.example.earthquakesquicksearch.databinding.Earthquake;
import com.example.earthquakesquicksearch.model.EarthquakeSearchModel;
import com.example.earthquakesquicksearch.model.IsearchModel;
import com.example.earthquakesquicksearch.pojo.EarthquakeResponse;
import com.example.earthquakesquicksearch.pojo.Feature;
import com.example.earthquakesquicksearch.view.ISearchView;

import java.util.ArrayList;
import java.util.List;

public class SearchPresenter implements IsearchPreseter {
    private ISearchView iSearchView;
    private IsearchModel isearchModel;


    public SearchPresenter(ISearchView iSearchView) {
        this.iSearchView = iSearchView;
        this.isearchModel = new EarthquakeSearchModel(this);
    }

    @Override
    public void fetchEarthquakesData(String format,String startTime,String endTime, String minMagnitude,String orderBy) {
        iSearchView.showProgressBar(true);
        isearchModel.search(format,startTime,endTime,minMagnitude,orderBy);

    }

    @Override
    public void fetchSuccess(EarthquakeResponse earthquakeResponse) {
        iSearchView.showProgressBar(false);
        //create a list of earthquake objests from earthquakeResponse
        List<Feature> featureList = earthquakeResponse.getFeatures();
        List<Earthquake> earthquakeList = new ArrayList<>();
        for(Feature e:featureList){
            Earthquake earthquake = new Earthquake(e.getProperties().getTitle(),e.getProperties().getTime().toString(),e.getProperties().getMag().toString());
            earthquakeList.add(earthquake);
        }
        iSearchView.showDetailAcitivty(earthquakeList);
    }

    @Override
    public void fetchFail() {
        iSearchView.showProgressBar(false);
        iSearchView.showFailToast();
    }
}
