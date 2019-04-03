package com.example.earthquakesquicksearch.pojo;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Geometry {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("coordinates")
    @Expose
    private List<Double> coordinates = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Geometry() {
    }

    /**
     *
     * @param type
     * @param coordinates
     */
    public Geometry(String type, List<Double> coordinates) {
        super();
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "type='" + type + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }



}
