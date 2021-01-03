package com.atcode.dentgram.data.EventById;

import com.google.gson.annotations.SerializedName;

public class SpeakerItem {
    @SerializedName("Id")
    public int id ;

    @SerializedName("Name")
    public String Name ;

    @SerializedName("Title")
    public String Title ;
    @SerializedName("Image")
    public String Image ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
