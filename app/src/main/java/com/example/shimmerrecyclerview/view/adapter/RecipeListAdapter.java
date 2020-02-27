package com.example.shimmerrecyclerview.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shimmerrecyclerview.R;
import com.example.shimmerrecyclerview.model.ShimmerResponce;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeListAdapter  extends RecyclerView.Adapter<RecipeListAdapter.MyViewHolder> {
    private Context context;
    List<ShimmerResponce> shimmerResponces;

    public RecipeListAdapter(Context applicationContext, List<ShimmerResponce> shimmerResponces) {
        this.context=applicationContext;
        this.shimmerResponces=shimmerResponces;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, price, chef, timestamp;
        public ImageView thumbnail;
        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            chef = view.findViewById(R.id.chef);
            description = view.findViewById(R.id.description);
            price = view.findViewById(R.id.price);
            thumbnail = view.findViewById(R.id.thumbnail);
            timestamp = view.findViewById(R.id.timestamp);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ShimmerResponce shimmerResponce=shimmerResponces.get(position);
        holder.name.setText(shimmerResponce.getName());
        holder.chef.setText("By " + shimmerResponce.getChef());
        holder.description.setText(shimmerResponce.getDescription());
        holder.price.setText("Price: ₹" + shimmerResponce.getPrice());
        holder.timestamp.setText(shimmerResponce.getTimestamp());

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);
        Glide.with(context).load(shimmerResponce.getThumbnail()).apply(options).into(holder.thumbnail);

       // Glide.with(context).load(shimmerResponce.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {

   return shimmerResponces.size();
    }
}
