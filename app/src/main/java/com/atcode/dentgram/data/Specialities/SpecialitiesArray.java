package com.atcode.dentgram.data.Specialities;

import com.atcode.dentgram.data.titles.TitleItem;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SpecialitiesArray {

    @SerializedName("Result")
    public ArrayList<SpecialitiesItem> specialities ;

    public ArrayList<SpecialitiesItem> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(ArrayList<SpecialitiesItem> specialities) {
        this.specialities = specialities;
    }
}
