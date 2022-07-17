package com.example.domain.interactor;

import com.example.domain.model.Tv;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface TvInteractor {

    Observable<List<Tv>> getPopularTv();

    Observable<List<Tv>> getAiringTodayTv();

    Observable<List<Tv>> getOnTVtv();

    Observable<List<Tv>> getTopRatedTv();
}

