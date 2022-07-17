package com.example.domain.interactor.internal;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.data.remote.dto.movie.MoviePopularDTO;
import com.example.data.remote.dto.movie.MovieResultPopular;
import com.example.data.remote.dto.trending.TrendingDTO;
import com.example.data.remote.dto.trending.TrendingResult;
import com.example.data.remote.dto.tv.TvPopularDTO;
import com.example.data.remote.dto.tv.TvResultPopular;
import com.example.data.remote.rest.APIClient;
import com.example.domain.interactor.HomeInteractor;
import com.example.domain.model.Tv;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeInteractorImpl implements HomeInteractor {
    public final String API_KEY = "31532b7e5b256339912895d84dd7fbc3";

    public HomeInteractorImpl() {

    }

    @Override
    public Observable<List<Tv>> getListPopularMovie() {
        return APIClient.apiClient.getListMovie("popular", API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<MoviePopularDTO, List<Tv>>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public List<Tv> apply(MoviePopularDTO moviePopularDTO) throws Throwable {
                        List<Tv> tvList = new ArrayList<>();
                        for (MovieResultPopular movieResultPopular : moviePopularDTO.getResults()) {
                            tvList.add(new Tv(Math.toIntExact(movieResultPopular.getId()), movieResultPopular.getTitle(),
                                    movieResultPopular.getReleaseDate(), movieResultPopular.getPosterPath(), "movie"));
                        }
                        return tvList;
                    }
                });
    }

    @Override
    public Observable<List<Tv>> getListPopularTv() {
        return APIClient.apiClient.getListTv("popular", API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<TvPopularDTO, List<Tv>>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public List<Tv> apply(TvPopularDTO tvPopularDTO) throws Throwable {
                        List<Tv> tvList = new ArrayList<>();
                        for (TvResultPopular tvResultPopular : tvPopularDTO.getResults()) {
                            tvList.add(new Tv(Math.toIntExact(tvResultPopular.getId()), tvResultPopular.getName(),
                                    tvResultPopular.getFirstAirDate(), tvResultPopular.getPosterPath(), "tv"));
                        }
                        return tvList;
                    }
                });
    }

    @Override
    public Observable<List<Tv>> getListTrendingDay() {
        return APIClient.apiClient.getListTrending("day", API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<TrendingDTO, List<Tv>>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public List<Tv> apply(TrendingDTO trendingDTO) throws Throwable {
                        List<Tv> tvList = new ArrayList<>();
                        for (TrendingResult trendingResult : trendingDTO.getResults()) {
                            if (Objects.equals(trendingResult.getmMediaType(), "tv")) {
                                tvList.add(new Tv(Math.toIntExact(trendingResult.getmId()), trendingResult.getmName(),
                                        trendingResult.getmFirstAirDate(), trendingResult.getmPosterPath(), "tv"));
                            } else if (Objects.equals(trendingResult.getmMediaType(), "movie")) {
                                tvList.add(new Tv(Math.toIntExact(trendingResult.getmId()), trendingResult.getmTitle(),
                                        trendingResult.getmReleaseDate(), trendingResult.getmPosterPath(), "movie"));
                            }
                        }
                        return tvList;
                    }
                });
    }

    @Override
    public Observable<List<Tv>> getListTrendingWeek() {
        return APIClient.apiClient.getListTrending("week", API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<TrendingDTO, List<Tv>>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public List<Tv> apply(TrendingDTO trendingDTO) throws Throwable {
                        List<Tv> tvList = new ArrayList<>();
                        for (TrendingResult trendingResult : trendingDTO.getResults()) {
                            if (Objects.equals(trendingResult.getmMediaType(), "tv")) {
                                tvList.add(new Tv(Math.toIntExact(trendingResult.getmId()), trendingResult.getmName(),
                                        trendingResult.getmFirstAirDate(), trendingResult.getmPosterPath(), "tv"));
                            } else if (Objects.equals(trendingResult.getmMediaType(), "movie")) {
                                tvList.add(new Tv(Math.toIntExact(trendingResult.getmId()), trendingResult.getmTitle(),
                                        trendingResult.getmReleaseDate(), trendingResult.getmPosterPath(), "movie"));
                            }
                        }
                        return tvList;
                    }
                });
    }
}
