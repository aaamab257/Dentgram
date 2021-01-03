package com.atcode.dentgram.data.countries;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Countries {
    @SerializedName("Result")
    public ArrayList<CountryItem> countries ;

    public ArrayList<CountryItem> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<CountryItem> countries) {
        this.countries = countries;
    }
}
