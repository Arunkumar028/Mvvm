package com.example.shimmerrecyclerview.service;

import com.example.shimmerrecyclerview.model.ShimmerResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiservice {
   @GET("shimmer/menu.php")
   Call<List<ShimmerResponce>> shimmerresponce();
}
