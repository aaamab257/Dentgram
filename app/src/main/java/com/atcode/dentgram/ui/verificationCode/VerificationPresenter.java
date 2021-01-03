package com.atcode.dentgram.ui.verificationCode;

import android.content.Context;

import com.atcode.dentgram.data.verifications.VerificationResponse;
import com.atcode.dentgram.utils.StaticMethods;
import com.atcode.dentgram.utils.network.ConnectionListener;
import com.atcode.dentgram.utils.network.ConnectionResponse;
import com.atcode.dentgram.utils.network.MainApi;

import okhttp3.RequestBody;

public class VerificationPresenter {

    VerificationListener verifys;

    public VerificationPresenter(VerificationListener verify) {
        this.verifys = verify;
    }

    public void verify(RequestBody body , Context context ){
        boolean network = StaticMethods.isConnectingToInternet(context) ;
        if(network){
            MainApi.verifyAccount(body ,new ConnectionListener<VerificationResponse>() {
                @Override
                public void onSuccess(ConnectionResponse<VerificationResponse> connectionResponse) {
                    verifys.onVerifySuccess(connectionResponse.data);
                }

                @Override
                public void onFail(Throwable throwable) {
                    verifys.onVerifyFail(throwable.getMessage());
                }
            });
        }else {
            verifys.onConnection(true);
        }
    }
}
