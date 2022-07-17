
package com.example.data.remote.dto.detail.detailmovie.credit;

import com.google.gson.annotations.SerializedName;

public class Crew {

    @SerializedName("adult")
    private Boolean mAdult;
    @SerializedName("credit_id")
    private String mCreditId;
    @SerializedName("department")
    private String mDepartment;
    @SerializedName("gender")
    private Long mGender;
    @SerializedName("id")
    private Long mId;
    @SerializedName("job")
    private String mJob;
    @SerializedName("known_for_department")
    private String mKnownForDepartment;
    @SerializedName("name")
    private String mName;
    @SerializedName("original_name")
    private String mOriginalName;
    @SerializedName("popularity")
    private Double mPopularity;
    @SerializedName("profile_path")
    private String mProfilePath;

    public Boolean getAdult() {
        return mAdult;
    }

    public void setAdult(Boolean adult) {
        mAdult = adult;
    }

    public String getCreditId() {
        return mCreditId;
    }

    public void setCreditId(String creditId) {
        mCreditId = creditId;
    }

    public String getDepartment() {
        return mDepartment;
    }

    public void setDepartment(String department) {
        mDepartment = department;
    }

    public Long getGender() {
        return mGender;
    }

    public void setGender(Long gender) {
        mGender = gender;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getJob() {
        return mJob;
    }

    public void setJob(String job) {
        mJob = job;
    }

    public String getKnownForDepartment() {
        return mKnownForDepartment;
    }

    public void setKnownForDepartment(String knownForDepartment) {
        mKnownForDepartment = knownForDepartment;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getOriginalName() {
        return mOriginalName;
    }

    public void setOriginalName(String originalName) {
        mOriginalName = originalName;
    }

    public Double getPopularity() {
        return mPopularity;
    }

    public void setPopularity(Double popularity) {
        mPopularity = popularity;
    }

    public String getProfilePath() {
        return mProfilePath;
    }

    public void setProfilePath(String profilePath) {
        mProfilePath = profilePath;
    }

}
