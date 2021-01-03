package com.atcode.dentgram.data.verifications;

import com.google.gson.annotations.SerializedName;

public class VerificationResponse {
    @SerializedName("Message")
    public String message ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
