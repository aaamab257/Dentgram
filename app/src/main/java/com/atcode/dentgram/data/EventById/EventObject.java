package com.atcode.dentgram.data.EventById;

import com.google.gson.annotations.SerializedName;

public class EventObject<T>{
    @SerializedName("Result")
    public T result ;

}
