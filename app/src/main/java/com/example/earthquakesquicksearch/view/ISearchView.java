package com.example.earthquakesquicksearch.view;

import com.example.earthquakesquicksearch.databinding.Earthquake;

import java.util.ArrayList;
import java.util.List;

public interface ISearchView {

    void showProgressBar(boolean show);

    void showDetailAcitivty(List<Earthquake> earthquakes);

    void showFailToast();
}
