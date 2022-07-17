package com.example.moviechill.movies;

import android.util.Log;
import android.widget.ProgressBar;

import com.example.domain.Domain;
import com.example.domain.model.Tv;
import com.example.moviechill.movies.tabfragment.nowplaying.NowPlayingMovieViewContact;
import com.example.moviechill.movies.tabfragment.popular.PopularMovieViewContact;
import com.example.moviechill.movies.tabfragment.toprated.TopRatedMovieViewContact;
import com.example.moviechill.movies.tabfragment.upcoming.UpcomingMovieViewContact;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MoviePresenter{
    Domain domain = new Domain();
    NowPlayingMovieViewContact nowPlayingMovieViewContact;
    PopularMovieViewContact popularMovieViewContact;
    TopRatedMovieViewContact topRatedMovieViewContact;
    UpcomingMovieViewContact upcomingMovieViewContact;

    public MoviePresenter(NowPlayingMovieViewContact nowPlayingMovieViewContact) {
        this.nowPlayingMovieViewContact = nowPlayingMovieViewContact;
    }

    public MoviePresenter(PopularMovieViewContact popularMovieViewContact) {
        this.popularMovieViewContact = popularMovieViewContact;
    }

    public MoviePresenter(TopRatedMovieViewContact topRatedMovieViewContact) {
        this.topRatedMovieViewContact = topRatedMovieViewContact;
    }

    public MoviePresenter(UpcomingMovieViewContact upcomingMovieViewContact) {
        this.upcomingMovieViewContact = upcomingMovieViewContact;
    }

    public void getMoviePopular() {
        domain.getMovieInteractor().getPopularMovie()
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        popularMovieViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvs) {
                        Log.d("checker", "onNext: " + tvs);
                        popularMovieViewContact.showPopularMovie(tvs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        popularMovieViewContact.onDismissLoading();
                    }
                });
    }

    public void getMovieNowPlaying() {
        domain.getMovieInteractor().getNowPlaying()
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        nowPlayingMovieViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvs) {
                        Log.d("checker", "onNext: " + tvs);
                        nowPlayingMovieViewContact.showNowPlayingMovie(tvs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        nowPlayingMovieViewContact.onDismissLoading();
                    }
                });
    }

    public void getMovieUpcoming() {
        domain.getMovieInteractor().getUpcomingMovie()
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        upcomingMovieViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvs) {
                        Log.d("checker", "onNext: " + tvs);
                        upcomingMovieViewContact.showUpcomingMovie(tvs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        upcomingMovieViewContact.onDismissLoading();
                    }
                });
    }

    public void getTopRatedMovie() {
        domain.getMovieInteractor().getTopRatedMovie()
                .subscribeWith(new Observer<List<Tv>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        topRatedMovieViewContact.onStartLoading();
                    }

                    @Override
                    public void onNext(@NonNull List<Tv> tvs) {
                        Log.d("checker", "onNext: " + tvs);
                        topRatedMovieViewContact.showTopRatedMovie(tvs);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        topRatedMovieViewContact.onDismissLoading();
                    }
                });
    }
}
