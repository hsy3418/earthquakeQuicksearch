package com.example.earthquakesquicksearch;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.earthquakesquicksearch.databinding.Earthquake;
import com.example.earthquakesquicksearch.presenter.SearchPresenter;
import com.example.earthquakesquicksearch.view.ISearchView;

import org.angmarch.views.NiceSpinner;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ISearchView, View.OnClickListener, AdapterView.OnItemSelectedListener{

    private NiceSpinner timeFrameSpinner;
    private NiceSpinner magnitudeSpinner;
    private NiceSpinner sortBySpinner;

    private Button searchButton;
    private String timeQuery;
    private String magQuery;
    private SearchPresenter searchPresenter;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        searchPresenter = new SearchPresenter(this);
        List<String> timeset = new LinkedList<>(Arrays.asList("Past 1 day", "Past 3 days", "Past 7 days", "Past 30days"));
        List<String> magnitudeSet = new LinkedList<>(Arrays.asList("M1.0+", "M2.5+", "M4.5+"));
        List<String> sortedbySet = new LinkedList<>(Arrays.asList("Time Desc", "Time Asc", "Magnitude Desc","Magnitude Asc"));

        magnitudeSpinner = (NiceSpinner) findViewById(R.id.magSpinner);
        magnitudeSpinner.attachDataSource(magnitudeSet);
        timeFrameSpinner = (NiceSpinner) findViewById(R.id.timeframeSpinner);
        timeFrameSpinner.attachDataSource(timeset);
        sortBySpinner = (NiceSpinner)findViewById(R.id.sortSpinner);
        sortBySpinner.attachDataSource(sortedbySet);

        sortBySpinner.setOnItemSelectedListener(this);
        timeFrameSpinner.setOnItemSelectedListener(this);
        magnitudeSpinner.setOnItemSelectedListener(this);

        searchButton = findViewById(R.id.searchbtn);
        searchButton.setOnClickListener(this);

    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
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
        Toast.makeText(this,"Something went wrong",Toast.LENGTH_LONG).show();
    }





    @Override
    public void onClick(View v) {
       String timeframeQuery = (String) timeFrameSpinner.getSelectedItem();
       String magQuery = (String)magnitudeSpinner.getSelectedItem();
       String sortBy = (String)sortBySpinner.getSelectedItem();

       String startTime  = getStartTime(timeframeQuery);
       String endTime = getEndTime();
       String minMag = getMinMag(magQuery);
       String orderBy = getSorted(sortBy);

        searchPresenter.fetchEarthquakesData("geojson",startTime,endTime,minMag,orderBy);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String item = parent.getItemAtPosition(position).toString();


        ((TextView) parent.getChildAt(0)).setTextSize(20);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private String getMinMag(String magQuery){
        String minMag;
        switch (magQuery){
            case "M1.0+":minMag="1";break;
            case "M2.5+": minMag = "2.5";break;
            case "M4.5+": minMag = "4.5";break;
            default:minMag="1"; break;

        }
        return minMag;
    }


    private String getStartTime(String timeFrameQuery)
    {
        DateTime startTime;
        switch (timeFrameQuery){
            case "Past 1 day": startTime = new DateTime().minusDays(1);break;
            case "Past 3 days": startTime = new DateTime().minusDays(3);break;
            case "Past 7 days": startTime = new DateTime().minusDays(7);break;
            case "Past 30days": startTime = new DateTime().minusDays(30);break;
            default:startTime = new DateTime().minusDays(1);break;
        }
        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("yyyy/MM/dd");

        return dtfOut.print(startTime);
    }


    private String getSorted(String sortedBy){
        String orderBy;
        switch (sortedBy){
            case "Time Desc" : orderBy = "time";break;
            case "Time Asc" : orderBy = "time-asc";break;
            case "Magnitude Desc" : orderBy = "magnitude";break;
            case "Magnitude Asc" : orderBy = "magnitude-asc";break;
            default:orderBy="time";
       }

       return orderBy;
    }

    private String getEndTime(){
        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("yyyy/MM/dd");
        DateTime currentDateTime = new DateTime();
        return dtfOut.print(currentDateTime);


    }

}
