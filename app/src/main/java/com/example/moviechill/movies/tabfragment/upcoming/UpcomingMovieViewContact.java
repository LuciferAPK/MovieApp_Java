package com.example.moviechill.movies.tabfragment.upcoming;

import com.example.domain.model.Tv;

import java.util.List;

public interface UpcomingMovieViewContact {
    void showUpcomingMovie(List<Tv> movieUpcoming);

    void onStartLoading();

    void onDismissLoading();
}
