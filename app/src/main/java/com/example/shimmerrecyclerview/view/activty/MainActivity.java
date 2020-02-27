package com.example.shimmerrecyclerview.view.activty;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.shimmerrecyclerview.MyviewModel;
import com.example.shimmerrecyclerview.R;
import com.example.shimmerrecyclerview.model.ShimmerResponce;
import com.example.shimmerrecyclerview.view.adapter.RecipeListAdapter;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        ViewModelProviders.of(this).get(MyviewModel.class);
    }

    private void fetchRecipes() {
        MyviewModel viewModel = ViewModelProviders.of(this).get(MyviewModel.class);
        viewModel.getUsers().observe(this, new Observer<List<ShimmerResponce>>() {
            @Override
            public void onChanged(List<ShimmerResponce> shimmerResponces) {
               mAdapter=new RecipeListAdapter(getApplicationContext(),shimmerResponces);
                recyclerView.setAdapter(mAdapter);
                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.GONE);
            }
        });



//        MyviewModel viewModel = ViewModelProviders.of(this).get(MyviewModel.class);
//        viewModel.getlivedata().observe(this, new Observer<List<ShimmerResponce>>() {
//            @Override
//            public void onChanged(List<ShimmerResponce> shimmerResponces) {
//                mAdapter = new RecipeListAdapter(getApplicationContext(), shimmerResponces);
//                recyclerView.setAdapter(mAdapter);
//                mShimmerViewContainer.stopShimmerAnimation();
//                mShimmerViewContainer.setVisibility(View.GONE);
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
        Toast.makeText(this, "resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mShimmerViewContainer.stopShimmerAnimation();
    }
}
