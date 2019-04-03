package com.example.earthquakesquicksearch.utils;

import okhttp3.OkHttpClient;

public class RestfulServiceWorker {

    private OkHttpClient okHttpClient;

    public RestfulServiceWorker(){
        okHttpClient = new OkHttpClient();
    }


}
