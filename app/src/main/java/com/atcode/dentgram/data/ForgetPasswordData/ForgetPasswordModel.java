package com.atcode.dentgram.data.ForgetPasswordData;

import com.google.gson.annotations.SerializedName;

public class ForgetPasswordModel {
    @SerializedName("UserId")
    public String userId ;
    @SerializedName("Token")
    public String token ;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
