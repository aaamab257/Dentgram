package com.atcode.dentgram.data.Cities;

import com.atcode.dentgram.data.countries.CountryItem;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CitiesArray {

    @SerializedName("Result")
    public ArrayList<Cityitem> cities ;


    public ArrayList<Cityitem> getCities() {
        return cities;
    }

    public void setCities(ArrayList<Cityitem> cities) {
        this.cities = cities;
    }
}
