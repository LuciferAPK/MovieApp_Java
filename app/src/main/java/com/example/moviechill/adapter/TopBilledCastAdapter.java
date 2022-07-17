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
import com.example.domain.model.Tv;
import com.example.moviechill.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopBilledCastAdapter extends RecyclerView.Adapter<TopBilledCastAdapter.TopBilledAdapter> {
    public final String base_url = "https://image.tmdb.org/t/p/w200";
    private final List<Detail> listDetail;
    private final LayoutInflater layoutInflater;

    public TopBilledCastAdapter(Context context, List<Detail> listDetail) {
        this.layoutInflater = LayoutInflater.from(context);
        this.listDetail = listDetail;
    }

    @NonNull
    @Override
    public TopBilledAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_billed, parent, false);
        return new TopBilledAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopBilledAdapter holder, int position) {
        Detail detail = listDetail.get(position);
        Picasso.get().load(base_url + detail.getBackdrop_path()).into(holder.img);
        holder.txtName.setText(detail.getTitle());
        holder.txtCharacter.setText(detail.getOverview());
    }

    @Override
    public int getItemCount() {
        return listDetail.size();
    }

    public static class TopBilledAdapter extends RecyclerView.ViewHolder {
        TextView txtName, txtCharacter;
        ImageView img;
        public TopBilledAdapter(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_topBilledName);
            txtCharacter = itemView.findViewById(R.id.txt_character);
            img = itemView.findViewById(R.id.img_topBilled);
        }
    }
}
