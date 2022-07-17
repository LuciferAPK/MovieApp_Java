
package com.example.data.remote.dto.detail.detailtv.tvdto;

import com.google.gson.annotations.SerializedName;


public class Logo {

    @SerializedName("aspect_ratio")
    private Double mAspectRatio;
    @SerializedName("path")
    private String mPath;

    public Double getAspectRatio() {
        return mAspectRatio;
    }

    public void setAspectRatio(Double aspectRatio) {
        mAspectRatio = aspectRatio;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

}
