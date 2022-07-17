package com.example.domain.interactor.internal;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.data.remote.dto.movie.MoviePopularDTO;
import com.example.data.remote.dto.movie.MovieResultPopular;
import com.example.data.remote.rest.APIClient;
import com.example.domain.interactor.MovieInteractor;
import com.example.domain.model.Tv;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MovieInteractorImpl implements MovieInteractor {
    public final String API_KEY = "31532b7e5b256339912895d84dd7fbc3";

    public MovieInteractorImpl() {

    }

    @Override
    public Observable<List<Tv>> getNowPlaying() {
        return APIClient.apiClient.getListMovie("now_playing", API_KEY)
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
    public Observable<List<Tv>> getUpcomingMovie() {
        return APIClient.apiClient.getListMovie("upcoming", API_KEY)
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
    public Observable<List<Tv>> getTopRatedMovie() {
        return APIClient.apiClient.getListMovie("top_rated", API_KEY)
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
    public Observable<List<Tv>> getPopularMovie() {
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

//    //API_Movie_Popular: https://api.themoviedb.org/3/movie/popular?api_key=31532b7e5b256339912895d84dd7fbc3
//    public void listMoviePopular(final MovieInteractor movieInteractor) {
//        APIClient.apiClient.getListMoviePopular(API_KEY).enqueue(new Callback<MoviePopularDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<MoviePopularDTO> call, Response<MoviePopularDTO> response) {
//                MoviePopularDTO moviePopularDTO = response.body();
//                List<MovieResultPopular> movieResultPopularList = moviePopularDTO.getResults();
//                List<Tv> moviePopular = new ArrayList<>();
//                for (MovieResultPopular t : movieResultPopularList) {
//                    moviePopular.add(new Tv(Math.toIntExact(t.getId()), t.getTitle(), t.getReleaseDate(),
//                            t.getPosterPath()));
//                }
//                movieInteractor.getPopularMovie(moviePopular);
//            }
//
//            @Override
//            public void onFailure(Call<MoviePopularDTO> call, Throwable t) {
//
//            }
//        });
//    }

//    //API_NowPlaying_Movie: https://api.themoviedb.org/3/movie/now_playing?api_key=31532b7e5b256339912895d84dd7fbc3
//    public void listMovieNowPlaying(final MovieInteractor movieInteractor) {
//        APIClient.apiClient.getListMovieNowPlaying(API_KEY).enqueue(new Callback<MoviePopularDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<MoviePopularDTO> call, Response<MoviePopularDTO> response) {
//                MoviePopularDTO moviePopularDTO = response.body();
//                List<MovieResultPopular> movieResultPopularList = moviePopularDTO.getResults();
//                List<Tv> movieNowPlaying = new ArrayList<>();
//                for (MovieResultPopular t : movieResultPopularList) {
//                    movieNowPlaying.add(new Tv(Math.toIntExact(t.getId()), t.getTitle(), t.getReleaseDate(),
//                            t.getPosterPath()));
//                }
//                movieInteractor.getNowPlaying(movieNowPlaying);
//            }
//
//            @Override
//            public void onFailure(Call<MoviePopularDTO> call, Throwable t) {
//
//            }
//        });
//    }
//
//    //API_Upcoming_Movie: https://api.themoviedb.org/3/movie/upcoming?api_key=31532b7e5b256339912895d84dd7fbc3
//    public void listMovieUpcoming(final MovieInteractor movieInteractor) {
//        APIClient.apiClient.getListMovieUpcoming(API_KEY).enqueue(new Callback<MoviePopularDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<MoviePopularDTO> call, Response<MoviePopularDTO> response) {
//                MoviePopularDTO moviePopularDTO = response.body();
//                List<MovieResultPopular> movieResultPopularList = moviePopularDTO.getResults();
//                List<Tv> movieUpcoming = new ArrayList<>();
//                for (MovieResultPopular t : movieResultPopularList) {
//                    movieUpcoming.add(new Tv(Math.toIntExact(t.getId()), t.getTitle(), t.getReleaseDate(),
//                            t.getPosterPath()));
//                }
//                movieInteractor.getUpcoming(movieUpcoming);
//            }
//
//            @Override
//            public void onFailure(Call<MoviePopularDTO> call, Throwable t) {
//
//            }
//        });
//    }
//
//    //API_TopRated_Movie: https://api.themoviedb.org/3/movie/top_rated?api_key=31532b7e5b256339912895d84dd7fbc3
//    public void listMovieTopRated(final MovieInteractor movieInteractor) {
//        APIClient.apiClient.getListMovieTopRated(API_KEY).enqueue(new Callback<MoviePopularDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<MoviePopularDTO> call, Response<MoviePopularDTO> response) {
//                MoviePopularDTO moviePopularDTO = response.body();
//                List<MovieResultPopular> movieResultPopularList = moviePopularDTO.getResults();
//                List<Tv> movieTopRated = new ArrayList<>();
//                for (MovieResultPopular t : movieResultPopularList) {
//                    movieTopRated.add(new Tv(Math.toIntExact(t.getId()), t.getTitle(), t.getReleaseDate(),
//                            t.getPosterPath()));
//                }
//                movieInteractor.getTopRatedMovie(movieTopRated);
//            }
//
//            @Override
//            public void onFailure(Call<MoviePopularDTO> call, Throwable t) {
//
//            }
//        });
//    }
}
