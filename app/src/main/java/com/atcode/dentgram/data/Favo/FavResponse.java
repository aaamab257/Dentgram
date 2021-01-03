package com.atcode.dentgram.data.Favo;

import com.google.gson.annotations.SerializedName;

public class FavResponse {
    @SerializedName("Message")
    public String message ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
