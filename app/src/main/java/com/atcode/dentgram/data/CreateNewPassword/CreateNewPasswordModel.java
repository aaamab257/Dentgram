package com.atcode.dentgram.data.CreateNewPassword;

import com.google.gson.annotations.SerializedName;

public class CreateNewPasswordModel {
    @SerializedName("Message")
    public String message ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
