package com.example.domain.interactor;

import com.example.domain.model.Tv;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface MovieInteractor {

    Observable<List<Tv>> getNowPlaying();

    Observable<List<Tv>> getUpcomingMovie();

    Observable<List<Tv>> getTopRatedMovie();

    Observable<List<Tv>> getPopularMovie();
}
