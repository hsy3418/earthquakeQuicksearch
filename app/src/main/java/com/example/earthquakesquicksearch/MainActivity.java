package com.example.earthquakesquicksearch;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.earthquakesquicksearch.databinding.Earthquake;
import com.example.earthquakesquicksearch.presenter.SearchPresenter;
import com.example.earthquakesquicksearch.view.ISearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ISearchView, View.OnClickListener {

    private RadioGroup magnitudeRg;
    private RadioGroup timeRg;
    private Button searchButton;
    private String timeQuery;
    private String magQuery;
    private SearchPresenter searchPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchPresenter = new SearchPresenter(this);
        magnitudeRg = findViewById(R.id.magRg);
        timeRg = findViewById(R.id.timeRg);
        searchButton = findViewById(R.id.searchbtn);
        searchButton.setOnClickListener(this);

    }

    @Override
    public void showDetailAcitivty(List<Earthquake> earthquakes) {
        Intent intent = new Intent(this, EarthquakeListActivity.class);

        Bundle bundle = new Bundle();

        bundle.putParcelableArrayList("mylist", (ArrayList<? extends Parcelable>) earthquakes);
        intent.putExtras(bundle);
        this.startActivity(intent);
    }

    @Override
    public void showFailToast() {

    }





    @Override
    public void onClick(View v) {

        String timeQuery ="";
        String magQuery="";

        int magChecked = magnitudeRg.getCheckedRadioButtonId();
        int timeChecked = timeRg.getCheckedRadioButtonId();

        switch (magChecked){
            case R.id.m2_5: magQuery = "2.5";break;
            case R.id.m5: magQuery = "5";break;
            default:magQuery = "2.5";break;
        }

        switch (timeChecked){
            //TODO get the starttime and end time
            case R.id.past1hrs:timeQuery = "";break;
            case R.id.past7hrs: timeQuery="";break;
            case R.id.past1week: timeQuery = "";break;
            case R.id.past1month: timeQuery="";break;
            default:timeQuery="";break;

        }

        searchPresenter.fetchEarthquakesData("geojson","2014-01-01","2014-01-02","5");


    }
}
