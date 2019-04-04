package com.example.earthquakesquicksearch.databinding;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Earthquake extends BaseObservable implements Parcelable {

    private String place;
    private String time;
    private String magnitude;

    public Earthquake(Parcel in) {
        this.place = in.readString();
        this.time = in.readString();
        this.magnitude = in.readString();

    }

    public Earthquake(String place, String time, String magnitude) {
        this.place = place;
        this.time = time;
        this.magnitude = magnitude;
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
