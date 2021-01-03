package com.atcode.dentgram.data.titles;

import com.atcode.dentgram.data.countries.CountryItem;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TitleArray {
    @SerializedName("Result")
    public ArrayList<TitleItem> titles ;

    public ArrayList<TitleItem> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<TitleItem> titles) {
        this.titles = titles;
    }
}
