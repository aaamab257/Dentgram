package com.atcode.dentgram.data.Specialities;

import com.google.gson.annotations.SerializedName;

public class SpecialitiesItem {

    @SerializedName("Id")
    public int id ;
    @SerializedName("Title")
    public String title ;

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

}
