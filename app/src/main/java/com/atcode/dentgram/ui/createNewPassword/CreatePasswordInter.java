package com.atcode.dentgram.ui.createNewPassword;

import com.atcode.dentgram.data.CreateNewPassword.CreateNewPasswordModel;

public interface CreatePasswordInter {
    void onCreatePassSuccess(CreateNewPasswordModel model);
    void onCreatePassFail(String fail);
    void onConnection(boolean isConnected);
}
