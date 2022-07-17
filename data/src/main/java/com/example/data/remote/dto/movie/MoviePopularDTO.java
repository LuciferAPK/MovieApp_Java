
package com.example.data.remote.dto.movie;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MoviePopularDTO {

    @SerializedName("page")
    private Long mPage;
    @SerializedName("results")
    private List<MovieResultPopular> mMovieResultPopulars;
    @SerializedName("total_pages")
    private Long mTotalPages;
    @SerializedName("total_results")
    private Long mTotalResults;

    public Long getPage() {
        return mPage;
    }

    public void setPage(Long page) {
        mPage = page;
    }

    public List<MovieResultPopular> getResults() {
        return mMovieResultPopulars;
    }

    public void setResults(List<MovieResultPopular> movieResultPopulars) {
        mMovieResultPopulars = movieResultPopulars;
    }

    public Long getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(Long totalPages) {
        mTotalPages = totalPages;
    }

    public Long getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(Long totalResults) {
        mTotalResults = totalResults;
    }

    @Override
    public String toString() {
        return "MPojo{" +
                "mPage=" + mPage +
                ", mResults=" + mMovieResultPopulars +
                ", mTotalPages=" + mTotalPages +
                ", mTotalResults=" + mTotalResults +
                '}';
    }
}
