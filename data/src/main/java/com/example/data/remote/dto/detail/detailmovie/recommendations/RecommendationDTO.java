
package com.example.data.remote.dto.detail.detailmovie.recommendations;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RecommendationDTO {

    @SerializedName("page")
    private Long mPage;
    @SerializedName("results")
    private List<RecommendationsResult> mRecommendationsResults;
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

    public List<RecommendationsResult> getResults() {
        return mRecommendationsResults;
    }

    public void setResults(List<RecommendationsResult> recommendationsResults) {
        mRecommendationsResults = recommendationsResults;
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
