package com.atcode.dentgram.data.loginData;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("Id")
    public String id ;
    @SerializedName("Token")
    public String token ;
    @SerializedName("Name")
    public String name ;
    @SerializedName("Image")
    public String image ;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
