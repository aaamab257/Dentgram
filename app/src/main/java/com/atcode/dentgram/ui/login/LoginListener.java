package com.atcode.dentgram.ui.login;

import com.atcode.dentgram.data.loginData.LoginData;

public interface LoginListener {
    void onLoginSuccess(LoginData data);
    void onLoginFail(String isFailed);
    void onConnection(boolean isConnected);
    void onEmptyFields(boolean isEmpty );
}
