
package com.example.data.remote.dto.detail.detailtv.tvdto;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Season {

    @SerializedName("air_date")
    private String mAirDate;
    @SerializedName("episode_count")
    private Long mEpisodeCount;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("networks")
    private List<Network> mNetworks;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("poster_path")
    private String mPosterPath;
    @SerializedName("season_number")
    private Long mSeasonNumber;

    public String getAirDate() {
        return mAirDate;
    }

    public void setAirDate(String airDate) {
        mAirDate = airDate;
    }

    public Long getEpisodeCount() {
        return mEpisodeCount;
    }

    public void setEpisodeCount(Long episodeCount) {
        mEpisodeCount = episodeCount;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<Network> getNetworks() {
        return mNetworks;
    }

    public void setNetworks(List<Network> networks) {
        mNetworks = networks;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public Long getSeasonNumber() {
        return mSeasonNumber;
    }

    public void setSeasonNumber(Long seasonNumber) {
        mSeasonNumber = seasonNumber;
    }

}
