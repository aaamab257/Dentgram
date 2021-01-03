package com.atcode.dentgram.data.EventsData;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EventsArray {
    @SerializedName("Result")
    public ArrayList<EventsItem> events;


    public ArrayList<EventsItem> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<EventsItem> events) {
        this.events = events;
    }
}
