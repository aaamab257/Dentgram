package com.atcode.dentgram.ui.login;

import android.content.Context;
import android.util.Log;

import com.atcode.dentgram.data.User;
import com.atcode.dentgram.data.loginData.LoginData;
import com.atcode.dentgram.utils.StaticMethods;
import com.atcode.dentgram.utils.ToastUtil;
import com.atcode.dentgram.utils.network.ConnectionListener;
import com.atcode.dentgram.utils.network.ConnectionResponse;
import com.atcode.dentgram.utils.network.MainApi;
import com.atcode.dentgram.utils.network.MainApiBody;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import okhttp3.RequestBody;

import static android.content.ContentValues.TAG;

public class LoginPresenter {
    LoginListener login;

    public LoginPresenter(LoginListener login) {
        this.login = login;
    }

    public void loginFun(Context context, String email, String pass) {
        boolean network = StaticMethods.isConnectingToInternet(context);
        if (network) {
            RequestBody body = null;
            try {
                body = MainApiBody.loginBody(email, pass);
            } catch (Exception e) {

            }
            MainApi.LoginApi(body, new ConnectionListener<User<LoginData>>() {
                @Override
                public void onSuccess(ConnectionResponse<User<LoginData>> connectionResponse) {
                    login.onLoginSuccess(connectionResponse.data.data);
                }

                @Override
                public void onFail(Throwable throwable) {
                    String statusCode = throwable.getMessage();

                    login.onLoginFail(statusCode);


                }
            });
        } else {
            login.onConnection(true);
        }
    }
}
