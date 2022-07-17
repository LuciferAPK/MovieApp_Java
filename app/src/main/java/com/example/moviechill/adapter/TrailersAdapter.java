package com.example.moviechill.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.model.Detail;
import com.example.moviechill.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.MovieTrailers> {
    private final List<Detail> listDetail;
    private final LayoutInflater layoutInflater;
    public final String base_ytb_head = "https://img.youtube.com/vi/";
    public final String base_ytb_last = "/mqdefault.jpg";

    public TrailersAdapter(Context context, List<Detail> listDetail) {
        this.layoutInflater = LayoutInflater.from(context);
        this.listDetail = listDetail;
    }

    @NonNull
    @Override
    public MovieTrailers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new TrailersAdapter.MovieTrailers(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieTrailers holder, int position) {
        Detail detail = listDetail.get(position);
        Picasso.get().load(base_ytb_head + detail.getKey() + base_ytb_last).into(holder.img_thumbnail);
        holder.txt_name.setText(detail.getTitle());
    }

    @Override
    public int getItemCount() {
        return listDetail.size();
    }

    public class MovieTrailers extends RecyclerView.ViewHolder{
        TextView txt_name;
        ImageView img_thumbnail;
        public MovieTrailers(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.name_trailers);
            img_thumbnail = itemView.findViewById(R.id.video_trailers);
        }
    }
}
