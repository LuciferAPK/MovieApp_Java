package com.example.moviechill.view.detail.moviedetail;

import com.example.domain.Domain;
import com.example.domain.model.Detail;
import com.example.domain.model.Tv;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MovieDetailPresenter {
    Domain domain = new Domain();
    MovieDetailViewContact movieDetailViewContact;
    long id;

    public MovieDetailPresenter(MovieDetailViewContact movieDetailViewContact, long id) {
        this.movieDetailViewContact = movieDetailViewContact;
        this.id = id;
    }

    public void getListMovieDetail() {
        domain.getDetailInteractor().getBasicDetailMovie(id)
                .subscribeWith(new Observer<Detail>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        movieDetailViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull Detail detail) {
                        movieDetailViewContact.showDetailBasic(detail);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        movieDetailViewContact.onDismissLoading();
                    }
                });
    }

    public void getListMovieCast() {
        domain.getDetailInteractor().getTopBilledMovie(id)
                .subscribeWith(new Observer<List<Detail>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Detail> details) {
                        movieDetailViewContact.showDetailCast(details);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getListMovieTrailers() {
        domain.getDetailInteractor().getTrailersMovie(id)
                .subscribeWith(new Observer<List<Detail>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Detail> details) {
                        movieDetailViewContact.showTrailers(details);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getListMovieRecommendatios() {
        domain.getDetailInteractor().getRecommendationsMovie(id)
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvList) {
                        movieDetailViewContact.showRecommendations(tvList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
