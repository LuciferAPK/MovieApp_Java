package com.example.moviechill.tvs.tabfragment.popular;

import com.example.domain.model.Tv;

import java.util.List;

public interface PopularTvViewContact {
    void showPopularTv(List<Tv> tvPopular);

    void onStartLoading();

    void onDismissLoading();
}
