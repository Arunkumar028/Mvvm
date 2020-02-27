package com.example.shimmerrecyclerview;

import com.example.shimmerrecyclerview.model.ShimmerResponce;
import com.example.shimmerrecyclerview.service.Apiclient;
import com.example.shimmerrecyclerview.service.Apiservice;
import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyviewModel extends ViewModel {

    private MutableLiveData<List<ShimmerResponce>> shimmerresponce;
    public LiveData<List<ShimmerResponce>> getUsers() {
        if (shimmerresponce == null) {
            shimmerresponce = new MutableLiveData<>();
            loaddata();
        }
        return shimmerresponce;
    }
    private void loaddata() {
        Apiservice apiservice = Apiclient.getRetrofit().create(Apiservice.class);
        Call<List<ShimmerResponce>> call = apiservice.shimmerresponce();
        call.enqueue(new Callback<List<ShimmerResponce>>() {
            @Override
            public void onResponse(Call<List<ShimmerResponce>> call, Response<List<ShimmerResponce>> response) {
                if (response.isSuccessful()) {
                    shimmerresponce.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ShimmerResponce>> call, Throwable t) {

            }
        });
    }


//    private MutableLiveData<List<ShimmerResponce>> shimmerResponces;
//    Context mcontext;
//
//    public LiveData<List<ShimmerResponce>> getlivedata() {
//        if (shimmerResponces == null) {
//            shimmerResponces = new MutableLiveData<>();
//            loaddata();
//        }
//        return shimmerResponces;
//    }
//
//    private void loaddata() {
//        Apiservice apiservice = Apiclient.getRetrofit().create(Apiservice.class);
//        Call<List<ShimmerResponce>> call = apiservice.shimmerresponce();
//        call.enqueue(new Callback<List<ShimmerResponce>>() {
//            @Override
//            public void onResponse(Call<List<ShimmerResponce>> call, Response<List<ShimmerResponce>> response) {
//                if (response.isSuccessful()) {
//                    shimmerResponces.setValue(response.body());
//                }
//           }
//
//            @Override
//            public void onFailure(Call<List<ShimmerResponce>> call, Throwable t) {
//                if (t instanceof Exception) {
//                    Toast.makeText(mcontext, "Code error", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(mcontext, "Internet error", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


}


