package com.example.domain.interactor;

import com.example.domain.model.Detail;
import com.example.domain.model.Tv;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface DetailInteractor {
    Observable<Detail> getBasicDetailMovie(long id);

    Observable<List<Detail>> getTopBilledMovie(long id);

    Observable<List<Detail>> getTrailersMovie(long id);

    Observable<List<Tv>> getRecommendationsMovie(long id);

    Observable<Detail> getBasicDetailTv(long id);

    Observable<List<Detail>> getTopBilledTv(long id);

    Observable<List<Detail>> getTrailersTv(long id);

    Observable<List<Tv>> getRecommendationsTv(long id);
}
