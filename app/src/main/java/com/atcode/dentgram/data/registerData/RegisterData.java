package com.atcode.dentgram.data.registerData;

import com.google.gson.annotations.SerializedName;

public class RegisterData {
    @SerializedName("Id")
    public String id;
    @SerializedName("Token")
    public String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
