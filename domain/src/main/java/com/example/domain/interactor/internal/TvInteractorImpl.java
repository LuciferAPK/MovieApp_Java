package com.example.domain.interactor.internal;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import com.example.data.remote.dto.tv.TvPopularDTO;
import com.example.data.remote.dto.tv.TvResultPopular;
import com.example.data.remote.rest.APIClient;
import com.example.domain.interactor.TvInteractor;
import com.example.domain.model.Tv;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvInteractorImpl implements TvInteractor{
    public final String API_KEY = "31532b7e5b256339912895d84dd7fbc3";

    public TvInteractorImpl(){}

    @Override
    public Observable<List<Tv>> getPopularTv() {
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
    public Observable<List<Tv>> getAiringTodayTv() {
        return APIClient.apiClient.getListTv("airing_today", API_KEY)
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
    public Observable<List<Tv>> getOnTVtv() {
        return APIClient.apiClient.getListTv("on_the_air", API_KEY)
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
    public Observable<List<Tv>> getTopRatedTv() {
        return APIClient.apiClient.getListTv("top_rated", API_KEY)
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

//    //API_TV_POPULAR: https://api.themoviedb.org/3/tv/popular?api_key=31532b7e5b256339912895d84dd7fbc3&language=en-US&page=1
//    public void tvPopular(final TvInteractor tvInteractor) {
//        APIClient.apiClient.getListTvsPopular(API_KEY).enqueue(new Callback<TvPopularDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<TvPopularDTO> call, Response<TvPopularDTO> response) {
//                TvPopularDTO tvPopularDTO = response.body();
//                List<TvResultPopular> tvResultPopularList = tvPopularDTO.getResults();
//                List<Tv> tvPopular = new ArrayList<>();
//                for (TvResultPopular t : tvResultPopularList) {
//                    tvPopular.add(new Tv(Math.toIntExact(t.getId()), t.getName(), t.getFirstAirDate(),
//                            t.getPosterPath()));
//                }
//                tvInteractor.getPopularTvs(tvPopular);
//            }
//
//            @Override
//            public void onFailure(Call<TvPopularDTO> call, Throwable t) {
//
//            }
//        });
//    }
//
//    //API_trending_day: https://api.themoviedb.org/3/trending/all/day?api_key=31532b7e5b256339912895d84dd7fbc3
//    public void trendingDay(final TvInteractor tvInteractor) {
//        APIClient.apiClient.getListTrendingDay(API_KEY).enqueue(new Callback<TrendingDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<TrendingDTO> call, Response<TrendingDTO> response) {
//                TrendingDTO trendingDTO = response.body();
//                List<TrendingResult> trendingResultList = trendingDTO.getResults();
//                List<Tv> tv = new ArrayList<>();
//                for (TrendingResult t : trendingResultList) {
//                    if (t.getTitle() != null) {
//                        tv.add(new Tv(Math.toIntExact(t.getId()), t.getTitle(), t.getReleaseDate(),
//                                t.getPosterPath()));
//                    }
//                }
//                tvInteractor.getTrendingDay(tv);
//            }
//
//            @Override
//            public void onFailure(Call<TrendingDTO> call, Throwable t) {
//
//            }
//        });
//    }
//
//    //API_Trending_Week: https://api.themoviedb.org/3/trending/all/week?api_key=31532b7e5b256339912895d84dd7fbc3
//    public void trendingWeek(final TvInteractor tvInteractor) {
//        APIClient.apiClient.getListTrendingWeek(API_KEY).enqueue(new Callback<TrendingDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<TrendingDTO> call, Response<TrendingDTO> response) {
//                TrendingDTO trendingDTO = response.body();
//                List<TrendingResult> trendingResultList = trendingDTO.getResults();
//                List<Tv> tv = new ArrayList<>();
//                for (TrendingResult t : trendingResultList) {
//                    if (t.getTitle() != null) {
//                        tv.add(new Tv(Math.toIntExact(t.getId()), t.getTitle(), t.getReleaseDate(),
//                                t.getPosterPath()));
//                    }
//                }
//                tvInteractor.getTrendingWeek(tv);
//            }
//
//            @Override
//            public void onFailure(Call<TrendingDTO> call, Throwable t) {
//
//            }
//        });
//    }
//
//    //API_AiringToday: https://api.themoviedb.org/3/tv/airing_today?api_key=31532b7e5b256339912895d84dd7fbc3
//    public void airingTodayTV(final TvInteractor tvInteractor) {
//        APIClient.apiClient.getListAiringTodayTV(API_KEY).enqueue(new Callback<TvPopularDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<TvPopularDTO> call, Response<TvPopularDTO> response) {
//                TvPopularDTO tvAiringToday = response.body();
//                List<TvResultPopular> resultAiringList = tvAiringToday.getResults();
//                List<Tv> tv = new ArrayList<>();
//                for (TvResultPopular t : resultAiringList) {
//                    tv.add(new Tv(Math.toIntExact(t.getId()), t.getName(), t.getFirstAirDate(),
//                            t.getPosterPath()));
//                }
//                tvInteractor.getAiringDayTv(tv);
//            }
//
//            @Override
//            public void onFailure(Call<TvPopularDTO> call, Throwable t) {
//
//            }
//        });
//    }
//
//    //API_ONTV: https://api.themoviedb.org/3/tv/on_the_air?api_key=31532b7e5b256339912895d84dd7fbc3
//    public void OnTV(final TvInteractor tvInteractor) {
//        APIClient.apiClient.getListOnTV(API_KEY).enqueue(new Callback<TvPopularDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<TvPopularDTO> call, Response<TvPopularDTO> response) {
//                TvPopularDTO tvOntv = response.body();
//                List<TvResultPopular> resultAiringList = tvOntv.getResults();
//                List<Tv> tv = new ArrayList<>();
//                for (TvResultPopular t : resultAiringList) {
//                    tv.add(new Tv(Math.toIntExact(t.getId()), t.getName(), t.getFirstAirDate(),
//                            t.getPosterPath()));
//                }
//                tvInteractor.getOnTv(tv);
//            }
//
//            @Override
//            public void onFailure(Call<TvPopularDTO> call, Throwable t) {
//
//            }
//        });
//    }
//
////API_TopRated: https://api.themoviedb.org/3/tv/top_rated?api_key=31532b7e5b256339912895d84dd7fbc3
//    public void topRatedTv(final TvInteractor tvInteractor) {
//        APIClient.apiClient.getListTopRatedTV(API_KEY).enqueue(new Callback<TvPopularDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<TvPopularDTO> call, Response<TvPopularDTO> response) {
//                TvPopularDTO tvTopRated = response.body();
//                List<TvResultPopular> resultAiringList = tvTopRated.getResults();
//                List<Tv> tv = new ArrayList<>();
//                for (TvResultPopular t : resultAiringList) {
//                    tv.add(new Tv(Math.toIntExact(t.getId()), t.getName(), t.getFirstAirDate(),
//                            t.getPosterPath()));
//                }
//                tvInteractor.getTopRatedTv(tv);
//            }
//
//            @Override
//            public void onFailure(Call<TvPopularDTO> call, Throwable t) {
//
//            }
//        });
//    }
}
