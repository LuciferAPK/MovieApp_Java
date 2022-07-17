package com.example.domain.interactor;

import com.example.domain.model.Tv;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface HomeInteractor {
    Observable<List<Tv>> getListPopularMovie();

    Observable<List<Tv>> getListPopularTv();

    Observable<List<Tv>> getListTrendingDay();

    Observable<List<Tv>> getListTrendingWeek();
}
