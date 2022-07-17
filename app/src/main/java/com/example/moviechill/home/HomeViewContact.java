package com.example.moviechill.home;

import com.example.domain.model.Tv;

import java.util.List;

public interface HomeViewContact {
    void showPopularList(List<Tv> listPopular);

    void showTrendingList(List<Tv> listTrending);

    void onStartLoading();

    void onDismissLoading();
}
