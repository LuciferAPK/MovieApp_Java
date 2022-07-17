package com.example.moviechill.view.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.domain.interactor.DetailInteractor;
import com.example.domain.interactor.internal.DetailInteractorImpl;
import com.example.domain.model.Detail;
import com.example.domain.model.Genres;
import com.example.moviechill.R;
import com.example.moviechill.adapter.TopBilledCastAdapter;
import com.example.moviechill.adapter.TrailersAdapter;
import com.example.moviechill.view.detail.moviedetail.MovieDetailFragment;
import com.example.moviechill.view.detail.tvdetail.TvDetailFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    ImageView star1, star2, star3, star4, star5;
//    DetailInteractorImpl detailInteractorImpl = new DetailInteractorImpl(this);
    int count = 0;
    public final String base_url200 = "https://image.tmdb.org/t/p/w200";
    public final String base_url500 = "https://image.tmdb.org/t/p/w500";
    TopBilledCastAdapter topBilledCastAdapter;
    TrailersAdapter trailersAdapter;
    RecyclerView rv_topBilled, rv_movieTrailers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("type");
        long id = bundle.getLong("idFilm");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (Objects.equals(type, "movie")) {
            fragmentTransaction.replace(R.id.detail_film, new MovieDetailFragment(id)).commit();
        } else if (Objects.equals(type, "tv")) {
            fragmentTransaction.replace(R.id.detail_film, new TvDetailFragment(id)).commit();
        }

//        detailInteractorImpl.MovieDetail(this, id);
//        detailInteractorImpl.TopBilledCast(this, id);
//        detailInteractorImpl.getMovieTrailers(this, id);
//        txt_name_detail.setText(nameDetail);
//        Picasso.get().load(base_url200 + img).into(img_detail);
//        setClickedIconFavorite();
    }

//    private void initView() {
//        txt_name_detail = findViewById(R.id.txt_name_detail);
//        txt_category_detail = findViewById(R.id.txt_category_detail);
//        txt_favorite = findViewById(R.id.txt_favorite);
//        txt_evaluate_detail = findViewById(R.id.txt_evaluate_detail);
//        txt_overview_detail = findViewById(R.id.txt_overview_detail);
//        img_detail = findViewById(R.id.img_detail);
//        img_favorite = findViewById(R.id.img_favorite);
//        img_bg = findViewById(R.id.img_bg);
//        star1 = findViewById(R.id.star1);
//        star2 = findViewById(R.id.star2);
//        star3 = findViewById(R.id.star3);
//        star4 = findViewById(R.id.star4);
//        star5 = findViewById(R.id.star5);
//        rv_topBilled = findViewById(R.id.rv_topBilled);
//        rv_movieTrailers = findViewById(R.id.trailers);
//    }

//    private void setClickedIconFavorite() {
//        img_favorite.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("UseCompatLoadingForDrawables")
//            @Override
//            public void onClick(View v) {
//                count += 1;
//                if (count % 2 != 0) {
//                    img_favorite.setBackground(getDrawable(R.drawable.ic_favorite));
//                    txt_favorite.setText("Your Favorite");
//                } else {
//                    img_favorite.setBackground(getDrawable(R.drawable.ic_favorite_border));
//                    txt_favorite.setText("Add to Favorite");
//                }
//            }
//        });
//    }

//    @Override
//    public void getMovieDetail(Detail detail) {
//        StringBuilder str = new StringBuilder();
//        Picasso.get().load(base_url500 + detail.getBackdrop_path()).into(img_bg);
//        setStar(detail.getVote_average());
//        txt_evaluate_detail.setText(detail.getVote_average() + "/10");
//        txt_overview_detail.setText(detail.getOverview());
//        for (Genres genres: detail.getGenres()) {
//            str.append(genres.getName()).append(" ");
//        }
//        txt_category_detail.setText(str.toString());
//    }

//    @Override
//    public void getTopBilled(List<Detail> detailList) {
//        topBilledCastAdapter = new TopBilledCastAdapter(this, detailList);
//        topBilledCastAdapter.notifyDataSetChanged();
//        rv_topBilled.setAdapter(topBilledCastAdapter);
//    }
//
//    @Override
//    public void getListMovieTrailers(List<Detail> detail) {
//        trailersAdapter = new TrailersAdapter(this, detail);
//        trailersAdapter.notifyDataSetChanged();
//        rv_movieTrailers.setAdapter(trailersAdapter);
//    }

//    @SuppressLint("UseCompatLoadingForDrawables")
//    private void setStar(Double voteAverage) {
//        if (voteAverage <= 2) {
//            star1.setBackground(getResources().getDrawable(R.drawable.ic_star));
//        } else if (voteAverage>2 && voteAverage<=4) {
//            star1.setBackground(getResources().getDrawable(R.drawable.ic_star));
//            star2.setBackground(getResources().getDrawable(R.drawable.ic_star));
//        } else if (voteAverage>4 && voteAverage<=6) {
//            star1.setBackground(getResources().getDrawable(R.drawable.ic_star));
//            star2.setBackground(getResources().getDrawable(R.drawable.ic_star));
//            star3.setBackground(getResources().getDrawable(R.drawable.ic_star));
//        } else if (voteAverage>6 && voteAverage<=8) {
//            star1.setBackground(getResources().getDrawable(R.drawable.ic_star));
//            star2.setBackground(getResources().getDrawable(R.drawable.ic_star));
//            star3.setBackground(getResources().getDrawable(R.drawable.ic_star));
//            star4.setBackground(getResources().getDrawable(R.drawable.ic_star));
//        } else if (voteAverage>8 && voteAverage<=10) {
//            star1.setBackground(getResources().getDrawable(R.drawable.ic_star));
//            star2.setBackground(getResources().getDrawable(R.drawable.ic_star));
//            star3.setBackground(getResources().getDrawable(R.drawable.ic_star));
//            star4.setBackground(getResources().getDrawable(R.drawable.ic_star));
//            star5.setBackground(getResources().getDrawable(R.drawable.ic_star));
//        }
//    }
}