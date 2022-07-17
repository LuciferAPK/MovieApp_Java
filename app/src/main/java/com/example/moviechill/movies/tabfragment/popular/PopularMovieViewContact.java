package com.example.moviechill.movies.tabfragment.popular;

import com.example.domain.model.Tv;

import java.util.List;

public interface PopularMovieViewContact {
    void showPopularMovie(List<Tv> moviePopular);

    void onStartLoading();

    void onDismissLoading();
}
