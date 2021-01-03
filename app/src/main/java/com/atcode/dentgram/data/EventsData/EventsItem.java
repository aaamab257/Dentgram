package com.atcode.dentgram.data.EventsData;

import com.google.gson.annotations.SerializedName;

public class EventsItem {
    @SerializedName("Id")
    public int id ;
    @SerializedName("FavId")
    public int FavId ;
    @SerializedName("Title")
    public String Title ;
    @SerializedName("Details")
    public String Details ;
    @SerializedName("Image")
    public String Image ;
    @SerializedName("ViewDate")
    public String ViewDate ;

    @SerializedName("Location")
    public String Location ;
    @SerializedName("HostedBy")
    public String HostedBy ;

    public int getFavId() {
        return FavId;
    }

    public void setFavId(int favId) {
        FavId = favId;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getViewDate() {
        return ViewDate;
    }

    public void setViewDate(String viewDate) {
        ViewDate = viewDate;
    }

    public String getHostedBy() {
        return HostedBy;
    }

    public void setHostedBy(String hostedBy) {
        HostedBy = hostedBy;
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



    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
