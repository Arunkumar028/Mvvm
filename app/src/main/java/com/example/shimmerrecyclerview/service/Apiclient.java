package com.example.shimmerrecyclerview.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {
    public static String Url="https://api.androidhive.info/json/";
    private static Retrofit retrofit=null;

    public static Retrofit getRetrofit() {
         retrofit = new Retrofit.Builder()
                .baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
