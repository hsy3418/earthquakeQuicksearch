package com.example.earthquakesquicksearch.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EarthquakeResponse {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;
    @SerializedName("bbox")
    @Expose
    private List<Double> bbox = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public EarthquakeResponse() {
    }

    /**
     *
     * @param bbox
     * @param features
     * @param type
     * @param metadata
     */
    public EarthquakeResponse(String type, Metadata metadata, List<Feature> features, List<Double> bbox) {
        super();
        this.type = type;
        this.metadata = metadata;
        this.features = features;
        this.bbox = bbox;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<Double> getBbox() {
        return bbox;
    }

    public void setBbox(List<Double> bbox) {
        this.bbox = bbox;
    }

    @Override
    public String toString() {
        return "EarthquakeResponse{" +
                "type='" + type + '\'' +
                ", metadata=" + metadata +
                ", features=" + features +
                ", bbox=" + bbox +
                '}';
    }
}
