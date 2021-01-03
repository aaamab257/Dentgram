package com.atcode.dentgram.utils.network;

public interface ConnectionListener<T> {
    void onSuccess(ConnectionResponse<T> connectionResponse);

    void onFail(Throwable throwable);
}
