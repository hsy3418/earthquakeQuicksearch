package com.example.earthquakesquicksearch.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Properties {

    @SerializedName("mag")
    @Expose
    private Double mag;
    @SerializedName("place")
    @Expose
    private String place;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("updated")
    @Expose
    private Integer updated;
    @SerializedName("tz")
    @Expose
    private Integer tz;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("felt")
    @Expose
    private Object felt;
    @SerializedName("cdi")
    @Expose
    private Object cdi;
    @SerializedName("mmi")
    @Expose
    private Object mmi;
    @SerializedName("alert")
    @Expose
    private Object alert;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tsunami")
    @Expose
    private Integer tsunami;
    @SerializedName("sig")
    @Expose
    private Integer sig;
    @SerializedName("net")
    @Expose
    private String net;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("ids")
    @Expose
    private String ids;
    @SerializedName("sources")
    @Expose
    private String sources;
    @SerializedName("types")
    @Expose
    private String types;
    @SerializedName("nst")
    @Expose
    private Object nst;
    @SerializedName("dmin")
    @Expose
    private Double dmin;
    @SerializedName("rms")
    @Expose
    private Double rms;
    @SerializedName("gap")
    @Expose
    private Integer gap;
    @SerializedName("magType")
    @Expose
    private String magType;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;

    /**
     * No args constructor for use in serialization
     *
     */
    public Properties() {
    }

    /**
     *
     * @param detail
     * @param type
     * @param net
     * @param tsunami
     * @param sources
     * @param title
     * @param time
     * @param updated
     * @param mag
     * @param place
     * @param types
     * @param status
     * @param alert
     * @param ids
     * @param rms
     * @param code
     * @param url
     * @param magType
     * @param mmi
     * @param cdi
     * @param tz
     * @param felt
     * @param nst
     * @param dmin
     * @param sig
     * @param gap
     */
    public Properties(Double mag, String place, Integer time, Integer updated, Integer tz, String url, String detail, Object felt, Object cdi, Object mmi, Object alert, String status, Integer tsunami, Integer sig, String net, String code, String ids, String sources, String types, Object nst, Double dmin, Double rms, Integer gap, String magType, String type, String title) {
        super();
        this.mag = mag;
        this.place = place;
        this.time = time;
        this.updated = updated;
        this.tz = tz;
        this.url = url;
        this.detail = detail;
        this.felt = felt;
        this.cdi = cdi;
        this.mmi = mmi;
        this.alert = alert;
        this.status = status;
        this.tsunami = tsunami;
        this.sig = sig;
        this.net = net;
        this.code = code;
        this.ids = ids;
        this.sources = sources;
        this.types = types;
        this.nst = nst;
        this.dmin = dmin;
        this.rms = rms;
        this.gap = gap;
        this.magType = magType;
        this.type = type;
        this.title = title;
    }

    public Double getMag() {
        return mag;
    }

    public void setMag(Double mag) {
        this.mag = mag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public Integer getTz() {
        return tz;
    }

    public void setTz(Integer tz) {
        this.tz = tz;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Object getFelt() {
        return felt;
    }

    public void setFelt(Object felt) {
        this.felt = felt;
    }

    public Object getCdi() {
        return cdi;
    }

    public void setCdi(Object cdi) {
        this.cdi = cdi;
    }

    public Object getMmi() {
        return mmi;
    }

    public void setMmi(Object mmi) {
        this.mmi = mmi;
    }

    public Object getAlert() {
        return alert;
    }

    public void setAlert(Object alert) {
        this.alert = alert;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTsunami() {
        return tsunami;
    }

    public void setTsunami(Integer tsunami) {
        this.tsunami = tsunami;
    }

    public Integer getSig() {
        return sig;
    }

    public void setSig(Integer sig) {
        this.sig = sig;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public Object getNst() {
        return nst;
    }

    public void setNst(Object nst) {
        this.nst = nst;
    }

    public Double getDmin() {
        return dmin;
    }

    public void setDmin(Double dmin) {
        this.dmin = dmin;
    }

    public Double getRms() {
        return rms;
    }

    public void setRms(Double rms) {
        this.rms = rms;
    }

    public Integer getGap() {
        return gap;
    }

    public void setGap(Integer gap) {
        this.gap = gap;
    }

    public String getMagType() {
        return magType;
    }

    public void setMagType(String magType) {
        this.magType = magType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "mag=" + mag +
                ", place='" + place + '\'' +
                ", time=" + time +
                ", updated=" + updated +
                ", tz=" + tz +
                ", url='" + url + '\'' +
                ", detail='" + detail + '\'' +
                ", felt=" + felt +
                ", cdi=" + cdi +
                ", mmi=" + mmi +
                ", alert=" + alert +
                ", status='" + status + '\'' +
                ", tsunami=" + tsunami +
                ", sig=" + sig +
                ", net='" + net + '\'' +
                ", code='" + code + '\'' +
                ", ids='" + ids + '\'' +
                ", sources='" + sources + '\'' +
                ", types='" + types + '\'' +
                ", nst=" + nst +
                ", dmin=" + dmin +
                ", rms=" + rms +
                ", gap=" + gap +
                ", magType='" + magType + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
