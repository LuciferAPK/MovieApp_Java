package com.example.data.remote.rest;

import com.example.data.remote.dto.detail.detailmovie.credit.CreditsDTO;
import com.example.data.remote.dto.detail.detailmovie.moviedto.DetailMovieDTO;
//import com.example.data.remote.dto.detail.detailmovie.credit.CreditsDTO;
//import com.example.data.remote.dto.detail.detailmovie.trailers.TrailersDTO;
import com.example.data.remote.dto.detail.detailmovie.trailers.TrailersDTO;
import com.example.data.remote.dto.detail.detailtv.credit.CreditsTvDTO;
import com.example.data.remote.dto.detail.detailtv.tvdto.DetailTvDTO;
import com.example.data.remote.dto.movie.MoviePopularDTO;
import com.example.data.remote.dto.trending.TrendingDTO;
import com.example.data.remote.dto.tv.TvPopularDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIClient {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-mm-dd")
            .create();

    APIClient apiClient = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIClient.class);

    //API_TV: https://api.themoviedb.org/3/tv/{param}?api_key=31532b7e5b256339912895d84dd7fbc3
    @GET("/3/tv/{param}")
    Observable<TvPopularDTO> getListTv(@Path("param") String param, @Query("api_key") String api_key);

    //API_MOVIE: https://api.themoviedb.org/3/movie/{param}?api_key=31532b7e5b256339912895d84dd7fbc3
    @GET("/3/movie/{param}")
    Observable<MoviePopularDTO> getListMovie(@Path("param") String param, @Query("api_key") String api_key);

    //API_TRENDING: https://api.themoviedb.org/3/trending/all/{param}?api_key=31532b7e5b256339912895d84dd7fbc3
    @GET("/3/trending/all/{param}")
    Observable<TrendingDTO> getListTrending(@Path("param") String param, @Query("api_key") String api_key);

    //API_Movie_Detail: https://api.themoviedb.org/3/movie/{movie_id}?api_key=31532b7e5b256339912895d84dd7fbc3
    @GET("/3/movie/{id}")
    Observable<DetailMovieDTO> getMovieDetail(@Path("id") long id, @Query("api_key") String api_key);

    //API_Movie_Credit: https://api.themoviedb.org/3/movie/{id}/credits?api_key=31532b7e5b256339912895d84dd7fbc3
    @GET("/3/movie/{id}/credits")
    Observable<CreditsDTO> getMovieCast(@Path("id") long id, @Query("api_key") String api_key);

    //API_Movie_Trailer: https://api.themoviedb.org/3/movie/{id}/videos?api_key=31532b7e5b256339912895d84dd7fbc3&language=en-US
    @GET("/3/movie/{id}/videos")
    Observable<TrailersDTO> getMovieTrailers(@Path("id") long id, @Query("api_key") String api_key);

    //API_Movie_Recomendations: https://api.themoviedb.org/3/movie/{movie_id}/recommendations?api_key=31532b7e5b256339912895d84dd7fbc3
    @GET("/3/movie/{id}/recommendations")
    Observable<MoviePopularDTO> getMovieRecommendations(@Path("id") long id, @Query("api_key") String api_key);

//    //API_Tv_Detail: https://api.themoviedb.org/3/tv/{tv_id}?api_key=31532b7e5b256339912895d84dd7fbc3
    @GET("/3/tv/{id}")
    Observable<DetailTvDTO> getTvDetail(@Path("id") long id, @Query("api_key") String api_key);

    //API_Tv_Credit: https://api.themoviedb.org/3/tv/{id}/credits?api_key=31532b7e5b256339912895d84dd7fbc3
    @GET("/3/tv/{id}/credits")
    Observable<CreditsTvDTO> getTvCast(@Path("id") long id, @Query("api_key") String api_key);

    //API_Tv_Trailer: https://api.themoviedb.org/3/tv/{66732}/videos?api_key=31532b7e5b256339912895d84dd7fbc3
    @GET("/3/tv/{id}/videos")
    Observable<TrailersDTO> getTvTrailers(@Path("id") long id, @Query("api_key") String api_key);

    //API_Movie_Recomendations: https://api.themoviedb.org/3/tv/{66732}/recommendations?api_key=31532b7e5b256339912895d84dd7fbc3
    @GET("/3/tv/{id}/recommendations")
    Observable<TvPopularDTO> getTvRecommendations(@Path("id") long id, @Query("api_key") String api_key);
}
