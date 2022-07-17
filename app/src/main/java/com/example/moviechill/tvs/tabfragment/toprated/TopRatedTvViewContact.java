package com.example.moviechill.tvs.tabfragment.toprated;

import com.example.domain.model.Tv;

import java.util.List;

public interface TopRatedTvViewContact {
    void showTopRatedTv(List<Tv> tvTopRated);

    void onStartLoading();

    void onDismissLoading();
}
