package com.example.earthquakesquicksearch.databinding;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Earthquake extends BaseObservable implements Parcelable {

    private String place;
    private String time;
    private String magnitude;
    private Double longitude;
    private Double latitude;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Earthquake(Parcel in) {
        this.place = in.readString();
        this.time = in.readString();
        this.magnitude = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();


    }

    public Earthquake(String place, String time, String magnitude,Double longitude,Double latitude) {
        this.place = place;
        this.time = time;
        this.magnitude = magnitude;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
       dest.writeString(place);
       dest.writeString(time);
       dest.writeString(magnitude);
       dest.writeDouble(latitude);
       dest.writeDouble(longitude);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Earthquake createFromParcel(Parcel in) {
            return new Earthquake(in);
        }

        public Earthquake[] newArray(int size) {
            return new Earthquake[size];
        }
    };

}
