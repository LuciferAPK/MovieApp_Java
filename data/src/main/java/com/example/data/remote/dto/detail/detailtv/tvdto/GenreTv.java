
package com.example.data.remote.dto.detail.detailtv.tvdto;

import com.google.gson.annotations.SerializedName;

public class GenreTv {

    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;

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

}
