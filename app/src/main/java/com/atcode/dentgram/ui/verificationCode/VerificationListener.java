package com.atcode.dentgram.ui.verificationCode;

import com.atcode.dentgram.data.verifications.VerificationResponse;

public interface VerificationListener {

    void onVerifySuccess(VerificationResponse response);
    void onVerifyFail(String code);
    void onConnection(boolean isConnected);

}
