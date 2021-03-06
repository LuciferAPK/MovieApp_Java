
package com.example.data.remote.dto.detail.detailtv.tvdto;

import com.google.gson.annotations.SerializedName;

public class SpokenLanguage {

    @SerializedName("english_name")
    private String mEnglishName;
    @SerializedName("iso_639_1")
    private String mIso6391;
    @SerializedName("name")
    private String mName;

    public String getEnglishName() {
        return mEnglishName;
    }

    public void setEnglishName(String englishName) {
        mEnglishName = englishName;
    }

    public String getIso6391() {
        return mIso6391;
    }

    public void setIso6391(String iso6391) {
        mIso6391 = iso6391;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
