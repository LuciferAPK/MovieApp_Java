package com.example.moviechill.tvs;

import android.content.Context;
import android.util.Log;

import com.example.domain.Domain;
import com.example.domain.model.Tv;
import com.example.moviechill.movies.tabfragment.popular.PopularMovieViewContact;
import com.example.moviechill.tvs.tabfragment.airingtoday.AiringTodayTvViewContact;
import com.example.moviechill.tvs.tabfragment.ontv.OnTvViewContact;
import com.example.moviechill.tvs.tabfragment.popular.PopularTvViewContact;
import com.example.moviechill.tvs.tabfragment.toprated.TopRatedTvViewContact;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TvPresenter {
    Domain domain = new Domain();
    AiringTodayTvViewContact airingTodayTvViewContact;
    OnTvViewContact onTvViewContact;
    PopularTvViewContact popularTvViewContact;
    TopRatedTvViewContact topRatedTvViewContact;

    public TvPresenter(AiringTodayTvViewContact airingTodayTvViewContact, Context context) {
        this.airingTodayTvViewContact = airingTodayTvViewContact;
    }

    public TvPresenter(OnTvViewContact onTvViewContact, Context context) {
        this.onTvViewContact = onTvViewContact;
    }

    public TvPresenter(PopularTvViewContact popularTvViewContact, Context context) {
        this.popularTvViewContact = popularTvViewContact;
    }

    public TvPresenter(TopRatedTvViewContact topRatedTvViewContact, Context context) {
        this.topRatedTvViewContact = topRatedTvViewContact;
    }

    public void getPopularTv() {
        domain.getTvInteractor().getPopularTv()
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        popularTvViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvs) {
                        Log.d("checker", "onNext: " + tvs);
                        popularTvViewContact.showPopularTv(tvs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        popularTvViewContact.onDismissLoading();
                    }
                });
    }

    public void getAiringTodayTv() {
        domain.getTvInteractor().getAiringTodayTv()
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        airingTodayTvViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvs) {
                        Log.d("checker", "onNext: " + tvs);
                        airingTodayTvViewContact.showAiringTodayTv(tvs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        airingTodayTvViewContact.onDismissLoading();
                    }
                });
    }

    public void getOnTV() {
        domain.getTvInteractor().getOnTVtv()
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        onTvViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvs) {
                        Log.d("checker", "onNext: " + tvs);
                        onTvViewContact.showOnTVTv(tvs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        onTvViewContact.onDismissLoading();
                    }
                });
    }

    public void getTopRatedTv() {
        domain.getTvInteractor().getTopRatedTv()
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        topRatedTvViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvs) {
                        Log.d("checker", "onNext: " + tvs);
                        topRatedTvViewContact.showTopRatedTv(tvs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        topRatedTvViewContact.onDismissLoading();
                    }
                });
    }
}
