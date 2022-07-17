package com.example.moviechill.view.detail.moviedetail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.model.Detail;
import com.example.domain.model.Tv;
import com.example.moviechill.R;
import com.example.moviechill.adapter.TopBilledCastAdapter;
import com.example.moviechill.adapter.TrailersAdapter;
import com.example.moviechill.adapter.ViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieDetailFragment extends Fragment implements MovieDetailViewContact {
    TextView txt_name_detail, txt_favorite, txt_evaluate_detail, txt_overview_detail, txt_category_detail;
    ImageView img_detail, img_favorite, img_bg;
    FrameLayout frameLayout;
    public final String base_url200 = "https://image.tmdb.org/t/p/w200";
    public final String base_url500 = "https://image.tmdb.org/t/p/w500";
    TopBilledCastAdapter topBilledCastAdapter;
    TrailersAdapter trailersAdapter;
    ViewAdapter viewAdapter;
    long id;
    int count = 0;
    RecyclerView rv_topBilled, rv_movieTrailers, rv_recommendations;
    MovieDetailPresenter movieDetailPresenter;

    public MovieDetailFragment(long id) {
        this.id = id;
        movieDetailPresenter = new MovieDetailPresenter(this, id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        initView(view);
        setClickedIconFavorite();
        movieDetailPresenter.getListMovieDetail();
        movieDetailPresenter.getListMovieCast();
        movieDetailPresenter.getListMovieTrailers();
        movieDetailPresenter.getListMovieRecommendatios();
        return view;
    }

    public void initView(View view) {
        txt_name_detail = view.findViewById(R.id.txt_name_detail_mv);
        txt_favorite = view.findViewById(R.id.txt_favorite_mv);
        txt_evaluate_detail = view.findViewById(R.id.txt_evaluate_detail_mv);
        txt_overview_detail = view.findViewById(R.id.txt_overview_detail_mv);
        txt_category_detail = view.findViewById(R.id.txt_category_detail_mv);
        img_detail = view.findViewById(R.id.img_detail_mv);
        img_favorite = view.findViewById(R.id.img_favorite_mv);
        img_bg = view.findViewById(R.id.img_bg_mv);
        frameLayout = view.findViewById(R.id.fr_loading);
        rv_topBilled = view.findViewById(R.id.rv_topBilled_mv);
        rv_movieTrailers = view.findViewById(R.id.trailers_mv);
        rv_recommendations = view.findViewById(R.id.rv_film_mv);
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
//        ratingBar.setRating((float) detail.getVote_average());
    }

    @Override
    public void showDetailCast(List<Detail> detailList) {
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
}
