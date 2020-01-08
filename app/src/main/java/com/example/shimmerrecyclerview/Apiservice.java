package com.example.shimmerrecyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface Apiservice {
   @GET("shimmer/menu.php")
   Call<List<ShimmerResponce>> shimmerresponce();
}
