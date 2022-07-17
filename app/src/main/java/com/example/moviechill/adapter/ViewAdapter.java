package com.example.moviechill.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.model.Tv;
import com.example.moviechill.R;
import com.example.moviechill.view.detail.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.TvViewHolder> {

    public final String base_url = "https://image.tmdb.org/t/p/w200";
    private final List<Tv> listTv;
    private final LayoutInflater layoutInflater;

    public ViewAdapter(Context context, List<Tv> listTv) {
        this.layoutInflater = LayoutInflater.from(context);
        this.listTv = listTv;
    }

    @NonNull
    @Override
    public ViewAdapter.TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img, parent, false);
        return new TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.TvViewHolder holder, int position) {
        Tv tv = listTv.get(position);
        Picasso.get().load(base_url + tv.getPoster_path()).into(holder.img);
        holder.txtName.setText(tv.getName());
        holder.txtDate.setText(tv.getFirst_air_date());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("type", tv.getType());
                bundle.putLong("idFilm", tv.getId());
                intent.putExtras(bundle);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTv.size();
    }

    public static class TvViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtDate;
        ImageView img;
        LinearLayout layoutItem;
        public TvViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtDate = itemView.findViewById(R.id.txt_date);
            img = itemView.findViewById(R.id.img_movie);
            layoutItem = itemView.findViewById(R.id.layout_item_film);
        }
    }
}
