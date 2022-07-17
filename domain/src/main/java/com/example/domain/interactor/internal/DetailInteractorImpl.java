package com.example.domain.interactor.internal;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.data.remote.dto.detail.detailmovie.credit.Cast;
import com.example.data.remote.dto.detail.detailmovie.credit.CreditsDTO;
import com.example.data.remote.dto.detail.detailmovie.moviedto.DetailMovieDTO;
import com.example.data.remote.dto.detail.detailmovie.moviedto.Genre;
import com.example.data.remote.dto.detail.detailmovie.trailers.TrailersDTO;
import com.example.data.remote.dto.detail.detailmovie.trailers.TrailersResult;
import com.example.data.remote.dto.detail.detailtv.credit.CastTv;
import com.example.data.remote.dto.detail.detailtv.credit.CreditsTvDTO;
import com.example.data.remote.dto.detail.detailtv.tvdto.DetailTvDTO;
import com.example.data.remote.dto.detail.detailtv.tvdto.GenreTv;
import com.example.data.remote.dto.movie.MoviePopularDTO;
import com.example.data.remote.dto.movie.MovieResultPopular;
import com.example.data.remote.dto.tv.TvPopularDTO;
import com.example.data.remote.dto.tv.TvResultPopular;
import com.example.data.remote.rest.APIClient;
import com.example.domain.interactor.DetailInteractor;
import com.example.domain.model.Detail;
import com.example.domain.model.Genres;
import com.example.domain.model.Tv;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DetailInteractorImpl implements DetailInteractor {
    public final String API_KEY = "31532b7e5b256339912895d84dd7fbc3";

    public DetailInteractorImpl() {

    }

    @Override
    public Observable<Detail> getBasicDetailMovie(long id) {
        return APIClient.apiClient.getMovieDetail(id, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<DetailMovieDTO, Detail>() {
                    @Override
                    public Detail apply(DetailMovieDTO detailMovieDTO) throws Throwable {
                        List<Genres> listGenres = new ArrayList<>();
                        for (Genre genre : detailMovieDTO.getGenres()) {
                            listGenres.add(new Genres(genre.getId(), genre.getName()));
                        }
                        Detail detail = new Detail(detailMovieDTO.getId(), detailMovieDTO.getTitle(),
                                detailMovieDTO.getBackdropPath(), detailMovieDTO.getPosterPath(), listGenres, detailMovieDTO.getVoteAverage(),
                                detailMovieDTO.getOverview(), detailMovieDTO.getRuntime(), detailMovieDTO.getReleaseDate(),
                                detailMovieDTO.getBudget());
                        return detail;
                    }
                });
    }

    @Override
    public Observable<List<Detail>> getTopBilledMovie(long id) {
        return APIClient.apiClient.getMovieCast(id, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<CreditsDTO, List<Detail>>() {
                         @Override
                         public List<Detail> apply(CreditsDTO creditsDTO) throws Throwable {
                             List<Cast> castList = creditsDTO.getCast();
                             List<Detail> detailList = new ArrayList<>();
                             for (Cast cast : castList) {
                                 detailList.add(new Detail(cast.getProfilePath(), cast.getName(), cast.getCharacter()));
                             }
                             return detailList;
                         }
                });
    }

    @Override
    public Observable<List<Detail>> getTrailersMovie(long id) {
        return APIClient.apiClient.getMovieTrailers(id, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<TrailersDTO, List<Detail>>() {
                    @Override
                    public List<Detail> apply(TrailersDTO trailersDTO) throws Throwable {
                        List<TrailersResult> trailersResultList = trailersDTO.getResults();
                        List<Detail> detailList = new ArrayList<>();
                        for (TrailersResult result : trailersResultList) {
                            detailList.add(new Detail(result.getName(), result.getKey()));
                        }
                        return detailList;
                    }
                });
    }

    @Override
    public Observable<List<Tv>> getRecommendationsMovie(long id) {
        return APIClient.apiClient.getMovieRecommendations(id, API_KEY)
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
    public Observable<Detail> getBasicDetailTv(long id) {
        return APIClient.apiClient.getTvDetail(id, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<DetailTvDTO, Detail>() {
                    @Override
                    public Detail apply(DetailTvDTO detailTvDTO) throws Throwable {
                        List<Genres> listGenres = new ArrayList<>();
                        for (GenreTv genreTv : detailTvDTO.getGenres()) {
                            listGenres.add(new Genres(genreTv.getId(), genreTv.getName()));
                        }
                        // error
                        Detail detail = new Detail(detailTvDTO.getId(), detailTvDTO.getName(),
                                detailTvDTO.getBackdropPath(), detailTvDTO.getPosterPath(), listGenres, detailTvDTO.getVoteAverage(),
                                detailTvDTO.getOverview(), detailTvDTO.getNumberOfEpisodes(), detailTvDTO.getFirstAirDate(),
                                detailTvDTO.getNumberOfSeasons(), detailTvDTO.getLastAirDate());
                        return detail;
                    }
                });
    }

    @Override
    public Observable<List<Detail>> getTopBilledTv(long id) {
        return APIClient.apiClient.getTvCast(id, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<CreditsTvDTO, List<Detail>>() {
                    @Override
                    public List<Detail> apply(CreditsTvDTO creditsTvDTO) throws Throwable {
                        List<CastTv> castList = creditsTvDTO.getCast();
                        List<Detail> detailList = new ArrayList<>();
                        for (CastTv castTv: castList) {
                            detailList.add(new Detail(castTv.getProfilePath(), castTv.getName(), castTv.getCharacter()));
                        }
                        return detailList;
                    }
                });
    }

    @Override
    public Observable<List<Detail>> getTrailersTv(long id) {
        return APIClient.apiClient.getTvTrailers(id, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<TrailersDTO, List<Detail>>() {
                    @Override
                    public List<Detail> apply(TrailersDTO trailersDTO) throws Throwable {
                        List<TrailersResult> trailersResultList = trailersDTO.getResults();
                        List<Detail> detailList = new ArrayList<>();
                        for (TrailersResult result : trailersResultList) {
                            detailList.add(new Detail(result.getName(), result.getKey()));
                        }
                        return detailList;
                    }
                });
    }

    @Override
    public Observable<List<Tv>> getRecommendationsTv(long id) {
        return APIClient.apiClient.getTvRecommendations(id, API_KEY)
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
//        APIClient.apiClient.getMovieDetail(id, API_KEY).enqueue(new Callback<DetailDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<DetailDTO> call, Response<DetailDTO> response) {
//                DetailDTO detailDTO = response.body();
//                List<Genre> listGenre = detailDTO.getGenres();
//                List<Genres> listGenres = new ArrayList<>();
//                for (Genre genre: listGenre) {
//                    listGenres.add(new Genres(genre.getId(), genre.getName()));
//                }
//                detailInteractor.getMovieDetail(new Detail(detailDTO.getId(), detailDTO.getTitle(),
//                        detailDTO.getBackdropPath(), listGenres, detailDTO.getVoteAverage(),
//                        detailDTO.getOverview(), detailDTO.getRuntime(), detailDTO.getReleaseDate(),
//                        detailDTO.getBudget()));
//            }
//
//            @Override
//            public void onFailure(Call<DetailDTO> call, Throwable t) {
//
//            }
//        });

//    //API_Movie_Credit: https://api.themoviedb.org/3/movie/{id}/credits?api_key=31532b7e5b256339912895d84dd7fbc3
//    public void TopBilledCast(final DetailInteractor detailInteractor, int id) {
//        APIClient.apiClient.getTopBilledCast(id, API_KEY).enqueue(new Callback<CreditsDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<CreditsDTO> call, Response<CreditsDTO> response) {
//                CreditsDTO creditsDTO = response.body();
//
//                List<Cast> castList = creditsDTO.getCast();
//                List<Detail> detailList = new ArrayList<>();
//                for (Cast cast: castList) {
//                    detailList.add(new Detail(cast.getProfilePath(), cast.getName(), cast.getCharacter()));
//                }
//                detailInteractor.getTopBilled(detailList);
//            }
//
//            @Override
//            public void onFailure(Call<CreditsDTO> call, Throwable t) {
//
//            }
//        });
//    }
//
//    //API_Movie_Trailer: https://api.themoviedb.org/3/movie/{id}/videos?api_key=31532b7e5b256339912895d84dd7fbc3&language=en-US
//    public void getMovieTrailers(final DetailInteractor detailInteractor, int id) {
//        APIClient.apiClient.getMovieTrailers(id, API_KEY).enqueue(new Callback<TrailersDTO>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<TrailersDTO> call, Response<TrailersDTO> response) {
//                TrailersDTO trailersDTO = response.body();
//
//                List<TrailersResult> trailersResultList = trailersDTO.getResults();
//                List<Detail> detailList = new ArrayList<>();
//                for (TrailersResult result: trailersResultList) {
//                    detailList.add(new Detail(result.getName()));
//                }
//                detailInteractor.getListMovieTrailers(detailList);
//            }
//
//            @Override
//            public void onFailure(Call<TrailersDTO> call, Throwable t) {
//
//            }
//        });
//    }

    }
