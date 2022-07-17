
package com.example.data.remote.dto.detail.detailmovie.trailers;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TrailersDTO {

    @SerializedName("id")
    private Long mId;
    @SerializedName("results")
    private List<TrailersResult> mTrailersResults;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<TrailersResult> getResults() {
        return mTrailersResults;
    }

    public void setResults(List<TrailersResult> trailersResults) {
        mTrailersResults = trailersResults;
    }

}
