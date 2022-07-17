
package com.example.data.remote.dto.detail.detailtv.credit;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CreditsTvDTO {

    @SerializedName("cast")
    private List<CastTv> mCastTv;
    @SerializedName("crew")
    private List<CrewTv> mCrewTv;
    @SerializedName("id")
    private Long mId;

    public List<CastTv> getCast() {
        return mCastTv;
    }

    public void setCast(List<CastTv> castTv) {
        mCastTv = castTv;
    }

    public List<CrewTv> getCrew() {
        return mCrewTv;
    }

    public void setCrew(List<CrewTv> crewTv) {
        mCrewTv = crewTv;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

}
