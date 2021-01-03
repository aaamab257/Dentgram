package com.atcode.dentgram.data.FeaturedEvents;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FeaturedEventArray {
    @SerializedName("Result")
    public ArrayList<FeatureEventItem> result ;

    public ArrayList<FeatureEventItem> getResult() {
        return result;
    }

    public void setResult(ArrayList<FeatureEventItem> result) {
        this.result = result;
    }
}
