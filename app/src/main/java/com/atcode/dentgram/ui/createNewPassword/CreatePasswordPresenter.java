package com.atcode.dentgram.ui.createNewPassword;

import android.content.Context;

import com.atcode.dentgram.data.CreateNewPassword.CreateNewPasswordModel;
import com.atcode.dentgram.utils.StaticMethods;
import com.atcode.dentgram.utils.network.ConnectionListener;
import com.atcode.dentgram.utils.network.ConnectionResponse;
import com.atcode.dentgram.utils.network.MainApi;

import okhttp3.RequestBody;

public class CreatePasswordPresenter {
    CreatePasswordInter createPasswordInter ;

    public CreatePasswordPresenter(CreatePasswordInter createPasswordInter) {
        this.createPasswordInter = createPasswordInter;
    }

    public void createPassword(Context context , RequestBody body ){
        boolean network = StaticMethods.isConnectingToInternet(context);
        if(network){
            MainApi.CreatePassword(body, new ConnectionListener<CreateNewPasswordModel>() {
                @Override
                public void onSuccess(ConnectionResponse<CreateNewPasswordModel> connectionResponse) {
                    createPasswordInter.onCreatePassSuccess(connectionResponse.data);
                }

                @Override
                public void onFail(Throwable throwable) {
                    createPasswordInter.onCreatePassFail(throwable.getMessage());
                }
            });
        }else {
            createPasswordInter.onConnection(true);
        }
    }
}
