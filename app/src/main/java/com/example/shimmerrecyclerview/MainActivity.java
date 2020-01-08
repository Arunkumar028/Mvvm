package com.example.shimmerrecyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ShimmerFrameLayout mShimmerViewContainer;

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private RecipeListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        fetchRecipes();
    }

    private void fetchRecipes() {
        Apiservice apiservice=Apiclient.getRetrofit().create(Apiservice.class);
        Call<List<ShimmerResponce>> call=apiservice.shimmerresponce();
        call.enqueue(new Callback<List<ShimmerResponce>>() {
            @Override
            public void onResponse(Call<List<ShimmerResponce>> call, Response<List<ShimmerResponce>> response) {
                if (response.isSuccessful()){
                    mAdapter=new RecipeListAdapter(getApplicationContext(),response.body());
                    recyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    // stop animating Shimmer and hide the layout
                    mShimmerViewContainer.stopShimmerAnimation();
                    mShimmerViewContainer.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Call<List<ShimmerResponce>> call, Throwable t) {
                if (t instanceof Exception){
                    Toast.makeText(MainActivity.this, "Code error", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Internet error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mShimmerViewContainer.stopShimmerAnimation();
    }
}
