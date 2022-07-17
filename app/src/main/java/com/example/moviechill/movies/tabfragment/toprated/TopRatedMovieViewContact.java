package com.example.moviechill.movies.tabfragment.toprated;

import com.example.domain.model.Tv;

import java.util.List;

public interface TopRatedMovieViewContact {
    void showTopRatedMovie(List<Tv> movieTopRated);

    void onStartLoading();

    void onDismissLoading();
}
