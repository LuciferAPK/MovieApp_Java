package com.example.moviechill.movies.tabfragment.nowplaying;

import com.example.domain.model.Tv;

import java.util.List;

public interface NowPlayingMovieViewContact {
    void showNowPlayingMovie(List<Tv> movieNowPlaying);

    void onStartLoading();

    void onDismissLoading();
}
