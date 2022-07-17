package com.example.moviechill.view.detail.moviedetail;

import com.example.domain.model.Detail;
import com.example.domain.model.Tv;

import java.util.List;

public interface MovieDetailViewContact {
    void showDetailBasic(Detail detail);

    void showDetailCast(List<Detail> detailList);

    void showTrailers(List<Detail> detailList);

    void showRecommendations(List<Tv> tvList);

    void onStartLoading();

    void onDismissLoading();
}
