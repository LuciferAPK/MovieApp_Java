
package com.example.data.remote.dto.tv;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TvPopularDTO {

    @Expose
    private Long page;
    @SerializedName("results")
    private List<TvResultPopular> tvResultPopularDTOS;
    @SerializedName("total_pages")
    private Long totalPages;
    @SerializedName("total_results")
    private Long totalResults;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public List<TvResultPopular> getResults() {
        return tvResultPopularDTOS;
    }

    public void setResults(List<TvResultPopular> tvResultPopularDTOS) {
        this.tvResultPopularDTOS = tvResultPopularDTOS;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public String toString() {
        return "TvPopular{" +
                "page=" + page +
                ", results=" + tvResultPopularDTOS +
                ", totalPages=" + totalPages +
                ", totalResults=" + totalResults +
                '}';
    }
}
