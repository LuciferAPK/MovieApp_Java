package com.example.moviechill.home;

import android.content.Context;
import android.util.Log;

import com.example.domain.Domain;
import com.example.domain.model.Tv;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class HomePresenter {
    Domain domain = new Domain();
    HomeViewContact homeViewContact;

    public HomePresenter(HomeViewContact homeViewContact) {
        this.homeViewContact = homeViewContact;
    }

    public void getListPopularMovie() {
        domain.getHomeInteractor().getListPopularMovie()
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        homeViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvs) {
                        Log.d("checker", "getListTrendingDay: " + tvs);
                        homeViewContact.showPopularList(tvs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        homeViewContact.onDismissLoading();
                    }
                });
    }

    public void getListPopularTv() {
        domain.getHomeInteractor().getListPopularTv()
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        homeViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvs) {
                        Log.d("checker", "onNext: " + tvs);
                        homeViewContact.showPopularList(tvs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        homeViewContact.onDismissLoading();
                    }
                });
    }

    public void getListTrendingDay() {
        domain.getHomeInteractor().getListTrendingDay()
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        homeViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvs) {
                        Log.d("checker", "getListTrendingDay: " + tvs);
                        homeViewContact.showTrendingList(tvs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        homeViewContact.onDismissLoading();
                    }
                });
    }

    public void getListTrendingWeek() {
        domain.getHomeInteractor().getListTrendingWeek()
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        homeViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvs) {
                        Log.d("checker", "onNext: " + tvs);
                        homeViewContact.showTrendingList(tvs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        homeViewContact.onDismissLoading();
                    }
                });
    }
}
