package com.example.earthquakesquicksearch;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.earthquakesquicksearch.databinding.Earthquake;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Double lon;
    private Double lat;
    private String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle b = getIntent().getExtras();
        Earthquake earthquake= b.getParcelable("earthquake");
        lon = earthquake.getLongitude();
        lat = earthquake.getLatitude();
        place = earthquake.getPlace();

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng earthquakePlace = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(earthquakePlace).title(place)).showInfoWindow();
        float zoomLevel = (float) 5.0;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(earthquakePlace, zoomLevel));
    }
}
