
package com.example.data.remote.dto.trending;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TrendingDTO {

    @SerializedName("page")
    private Long mPage;
    @SerializedName("results")
    private List<TrendingResult> mTrendingResults;
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

    public List<TrendingResult> getResults() {
        return mTrendingResults;
    }

    public void setResults(List<TrendingResult> trendingResults) {
        mTrendingResults = trendingResults;
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

}
