package com.atcode.dentgram.data.FeaturedEvents;

import com.google.gson.annotations.SerializedName;

public class FeatureEventItem {
    @SerializedName("Id")
    public int id ;
    @SerializedName("Title")
    public String Title ;
    @SerializedName("Details")
    public String Details ;
    @SerializedName("ViewDate")
    public String ViewDate;
    @SerializedName("Location")
    public String Location ;

    @SerializedName("Image")
    public String image ;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getViewDate() {
        return ViewDate;
    }

    public void setViewDate(String viewDate) {
        ViewDate = viewDate;
    }



    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
