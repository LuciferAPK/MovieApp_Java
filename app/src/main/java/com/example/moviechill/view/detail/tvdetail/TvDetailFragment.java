package com.example.moviechill.view.detail.tvdetail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.Domain;
import com.example.domain.model.Detail;
import com.example.domain.model.Tv;
import com.example.moviechill.R;
import com.example.moviechill.adapter.TopBilledCastAdapter;
import com.example.moviechill.adapter.TrailersAdapter;
import com.example.moviechill.adapter.ViewAdapter;
import com.example.moviechill.tvs.TvPresenter;
import com.example.moviechill.view.detail.moviedetail.MovieDetailPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TvDetailFragment extends Fragment implements TvDetailViewContact{
    TvDetailPresenter tvDetailPresenter;
    long id;
    int count = 0;
    TextView txt_name_detail, txt_favorite, txt_evaluate_detail, txt_overview_detail, txt_category_detail;
    ImageView img_detail, img_favorite, img_bg;
    RecyclerView rv_topBilled, rv_movieTrailers, rv_recommendations;
    TopBilledCastAdapter topBilledCastAdapter;
    TrailersAdapter trailersAdapter;
    ViewAdapter viewAdapter;
    FrameLayout frameLayout;
    public final String base_url200 = "https://image.tmdb.org/t/p/w200";
    public final String base_url500 = "https://image.tmdb.org/t/p/w500";

    public TvDetailFragment(long id) {
        this.id = id;
        tvDetailPresenter = new TvDetailPresenter(this, id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv_detail, container, false);
        initView(view);
        setClickedIconFavorite();
        tvDetailPresenter.getListTvDetail();
        tvDetailPresenter.getListTvCast();
        tvDetailPresenter.getListTvTrailers();
        tvDetailPresenter.getListTvRecommendatios();
        return view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showDetailBasic(Detail detail) {
        txt_name_detail.setText(detail.getTitle());
        txt_overview_detail.setText(detail.getOverview());
        Picasso.get().load(base_url500 + detail.getBackdrop_path()).into(img_bg);
        Picasso.get().load(base_url200 + detail.getPoster_path()).into(img_detail);
        txt_evaluate_detail.setText(detail.getVote_average() + "/10");
        StringBuilder genres = new StringBuilder();
        for (int i = 0; i < detail.getGenres().size(); i++) {
            if (i == detail.getGenres().size() - 1) {
                genres.append(detail.getGenres().get(i).getName());
            } else {
                genres.append(detail.getGenres().get(i).getName()).append(", ");
            }
        }
        txt_category_detail.setText(genres);
    }

    @Override
    public void showDetailCast(List<Detail> detailList) {
        Log.d("checker", "showDetailCast: " + detailList);
        topBilledCastAdapter = new TopBilledCastAdapter(getContext(), detailList);
        rv_topBilled.setAdapter(topBilledCastAdapter);
    }

    @Override
    public void showTrailers(List<Detail> detailList) {
        trailersAdapter = new TrailersAdapter(getContext(), detailList);
        rv_movieTrailers.setAdapter(trailersAdapter);
    }

    @Override
    public void showRecommendations(List<Tv> tvList) {
        viewAdapter = new ViewAdapter(getContext(), tvList);
        rv_recommendations.setAdapter(viewAdapter);
    }

    @Override
    public void onStartLoading() {
        frameLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDismissLoading() {
        frameLayout.setVisibility(View.GONE);
    }

    public void initView(View view) {
        txt_name_detail = view.findViewById(R.id.txt_name_detail_tv);
        txt_favorite = view.findViewById(R.id.txt_favorite_tv);
        txt_evaluate_detail = view.findViewById(R.id.txt_evaluate_detail_tv);
        txt_overview_detail = view.findViewById(R.id.txt_overview_detail_tv);
        txt_category_detail = view.findViewById(R.id.txt_category_detail_tv);
        img_detail = view.findViewById(R.id.img_detail_tv);
        img_favorite = view.findViewById(R.id.img_favorite_tv);
        img_bg = view.findViewById(R.id.img_bg_tv);
        frameLayout = view.findViewById(R.id.fr_loading);
        rv_topBilled = view.findViewById(R.id.rv_topBilled_tv);
        rv_movieTrailers = view.findViewById(R.id.trailers_tv);
        rv_recommendations = view.findViewById(R.id.rv_film_tv);
    }

    private void setClickedIconFavorite() {
        img_favorite.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                count += 1;
                if (count % 2 != 0) {
                    img_favorite.setBackground(getResources().getDrawable(R.drawable.ic_favorite));
                    txt_favorite.setText("Your Favorite");
                } else {
                    img_favorite.setBackground(getResources().getDrawable(R.drawable.ic_favorite_border));
                    txt_favorite.setText("Add to Favorite");
                }
            }
        });
    }
}
