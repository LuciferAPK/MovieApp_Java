package com.example.domain.model;

import java.util.List;

public class Detail {
    private long id;
    private String title;
    private String backdrop_path;
    private String poster_path;
    private List<Genres> genres;
    private double vote_average;
    private String overview;
    private long runTime;
    private String release_date;
    private long budget;
    private String key;
    private String last_air_date;


    public Detail(String title, String key) {
        this.title = title;
        this.key = key;
    }

    public Detail(String backdrop_path, String title, String overview) {
        this.backdrop_path = backdrop_path;
        this.title = title;
        this.overview = overview;
    }

    public Detail(long id, String title, String backdrop_path, String poster_path, List<Genres> genresList, double vote_average, String overview, long runTime, String release_date, long budget) {
        this.id = id;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.genres = genresList;
        this.vote_average = vote_average;
        this.overview = overview;
        this.runTime = runTime;
        this.release_date = release_date;
        this.budget = budget;
    }

    public Detail(long id, String title, String backdrop_path, String poster_path, List<Genres> genresList, double vote_average, String overview, long runTime, String release_date, long budget, String last_air_date) {
        this.id = id;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.poster_path = poster_path;
        this.genres = genresList;
        this.vote_average = vote_average;
        this.overview = overview;
        this.runTime = runTime;
        this.release_date = release_date;
        this.budget = budget;
        this.last_air_date = last_air_date;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public void setLast_air_date(String last_air_date) {
        this.last_air_date = last_air_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public double getVote_average() {
        return vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public long getRunTime() {
        return runTime;
    }

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", genres=" + genres +
                ", vote_average=" + vote_average +
                ", overview='" + overview + '\'' +
                ", runTime=" + runTime +
                ", release_date='" + release_date + '\'' +
                ", budget='" + budget + '\'' +
                '}';
    }
}
