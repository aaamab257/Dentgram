package com.atcode.dentgram.ui.forgetPassword;

import com.atcode.dentgram.data.ForgetPasswordData.ForgetObject;
import com.atcode.dentgram.data.ForgetPasswordData.ForgetPasswordModel;

public interface ForgetPassword {

    void onForgetSuccess(ForgetObject<ForgetPasswordModel> forget);
    void onForgetFail(String code);
    void onConnection(boolean isConnected);

}
