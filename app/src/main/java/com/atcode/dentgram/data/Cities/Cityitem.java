package com.atcode.dentgram.data.Cities;

import com.google.gson.annotations.SerializedName;

public class Cityitem {
    @SerializedName("Id")
    public int id ;
    @SerializedName("Title")
    public String title ;
    @SerializedName("CountryPhoneCode")
    public String CountryPhoneCode ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountryPhoneCode() {
        return CountryPhoneCode;
    }

    public void setCountryPhoneCode(String countryPhoneCode) {
        CountryPhoneCode = countryPhoneCode;
    }
}
