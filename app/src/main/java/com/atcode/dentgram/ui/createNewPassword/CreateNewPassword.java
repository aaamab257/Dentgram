package com.atcode.dentgram.ui.createNewPassword;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.data.CreateNewPassword.CreateNewPasswordModel;
import com.atcode.dentgram.databinding.FragmentCreateNewPasswordBinding;
import com.atcode.dentgram.utils.CustomDialog;
import com.atcode.dentgram.utils.ToastUtil;
import com.atcode.dentgram.utils.network.MainApi;
import com.atcode.dentgram.utils.network.MainApiBody;

import okhttp3.RequestBody;


public class CreateNewPassword extends Fragment implements CreatePasswordInter {

    FragmentCreateNewPasswordBinding binding ;
    View v ;
    CreatePasswordHandler handler ;
    CustomDialog dialog;
    String userId = "";
    CreatePasswordPresenter pre;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_new_password, container, false);
        v = binding.getRoot();
        handler = new CreatePasswordHandler(getActivity());
        binding.setHandler(handler);
        pre = new CreatePasswordPresenter(this);
        dialog = new CustomDialog(getActivity());
        getBun();
        return v;
    }
    private void getBun() {
        userId = getArguments().getString("userId");
    }

    @Override
    public void onCreatePassSuccess(CreateNewPasswordModel model) {
        dialog.DismissDialog();
        Navigation.findNavController(v).navigate(R.id.action_createNewPassword_to_loginScreen);
        ToastUtil.showSuccessToast(getActivity() , "Password created Successfully");
    }

    @Override
    public void onCreatePassFail(String fail) {
        dialog.DismissDialog();
        ToastUtil.showErrorToast(getActivity() , "Please try again");
    }

    @Override
    public void onConnection(boolean isConnected) {
        dialog.DismissDialog();
        ToastUtil.showErrorToast(getActivity() , "No internet Connection");
    }

    public class CreatePasswordHandler {
        Context context ;

        public CreatePasswordHandler(Context context) {
            this.context = context;
        }
        public void resetPassword(View v){
            dialog.ShowDialog();
            if(binding.edNewPassword.getText().toString().isEmpty()){
                dialog.DismissDialog();
                ToastUtil.showErrorToast(getActivity() ,"Enter your new password");
            }else if(!binding.edNewPassword.getText().toString().equals(binding.edConfirmPassword.getText().toString())){
                dialog.DismissDialog();
                ToastUtil.showErrorToast(getActivity() ,"Password does not match");
            }else {
                RequestBody body = null ;
                try {
                    body = MainApiBody.createPassword(userId ,binding.edNewPassword.getText().toString() );
                }catch (Exception e){

                }
                pre.createPassword(getActivity() , body);
            }
        }
    }
}