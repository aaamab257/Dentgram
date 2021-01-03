package com.atcode.dentgram.ui.forgetPassword;

import android.content.Context;

import com.atcode.dentgram.data.ForgetPasswordData.ForgetObject;
import com.atcode.dentgram.data.ForgetPasswordData.ForgetPasswordModel;
import com.atcode.dentgram.utils.StaticMethods;
import com.atcode.dentgram.utils.network.ConnectionListener;
import com.atcode.dentgram.utils.network.ConnectionResponse;
import com.atcode.dentgram.utils.network.MainApi;

import okhttp3.RequestBody;

public class ForgetPasswordPresenter {

    ForgetPassword forget ;

    public ForgetPasswordPresenter(ForgetPassword forget) {
        this.forget = forget;
    }

    public void forgetApi(Context context , RequestBody body){
        boolean network = StaticMethods.isConnectingToInternet(context);
        if(network){
            MainApi.ForgetPassword(body, new ConnectionListener<ForgetObject<ForgetPasswordModel>>() {
                @Override
                public void onSuccess(ConnectionResponse<ForgetObject<ForgetPasswordModel>> connectionResponse) {
                    forget.onForgetSuccess(connectionResponse.data);
                }

                @Override
                public void onFail(Throwable throwable) {
                    forget.onForgetFail(throwable.getMessage());
                }
            });
        }else {
            forget.onConnection(true);
        }
    }
}
