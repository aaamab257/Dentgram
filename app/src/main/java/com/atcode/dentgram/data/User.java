package com.atcode.dentgram.data;

import com.google.gson.annotations.SerializedName;

public class User<T> {
    @SerializedName("Data")
    public T data ;
}
