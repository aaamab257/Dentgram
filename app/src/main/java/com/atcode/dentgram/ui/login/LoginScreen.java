package com.atcode.dentgram.ui.login;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.atcode.dentgram.R;
import com.atcode.dentgram.data.loginData.LoginData;
import com.atcode.dentgram.databinding.FragmentLoginScreenBinding;
import com.atcode.dentgram.helpers.prefs.PrefUtils;
import com.atcode.dentgram.utils.CustomDialog;
import com.atcode.dentgram.utils.StaticMethods;
import com.atcode.dentgram.utils.ToastUtil;
import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class LoginScreen extends Fragment implements LoginListener {

    FragmentLoginScreenBinding binding ;
    View v ;
    LoginHandler handler ;
    LoginPresenter presenter ;
    CustomDialog dialog ;
    boolean network ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_screen, container, false);
        v = binding.getRoot();
        network = StaticMethods.isConnectingToInternet(getActivity());
        if(!network){
            binding.nested.setVisibility(View.GONE);
            binding.noNetwork.setVisibility(View.VISIBLE);
        }
        handler = new LoginHandler(getActivity());
        binding.setHandler(handler);
        presenter = new LoginPresenter(this);
        dialog = new CustomDialog(getActivity());

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        return v;
    }

    @Override
    public void onLoginSuccess(LoginData data) {
        if(!data.token.isEmpty()){
            dialog.DismissDialog();
            ToastUtil.showSuccessToast(getActivity() , "Login Successfully");
            StaticMethods.userData = data;
            PrefUtils.saveUserinformation(getActivity(), data, PrefUtils.User_Singin);
            Navigation.findNavController(v).navigate(R.id.action_loginScreen_to_mainScreen);
        }
    }

    @Override
    public void onLoginFail(String isFailed) {

        String [] parts = isFailed.split(" ");

        if(parts[1].equals("412")){
            ToastUtil.showErrorToast(getActivity() , "verify your Account first!");
            dialog.DismissDialog();
        }else {
            ToastUtil.showErrorToast(getActivity() , "Invalid Email or password");
            dialog.DismissDialog();
        }

    }

    @Override
    public void onConnection(boolean isConnected) {
        ToastUtil.showErrorToast(getActivity() , "No connection");
        dialog.DismissDialog();
    }

    @Override
    public void onEmptyFields(boolean isEmpty) {

    }

    public class LoginHandler{
        Context context ;

        public LoginHandler(Context context) {
            this.context = context;
        }
        public void register(View v){
            Navigation.findNavController(v).navigate(R.id.action_loginScreen_to_registerScreen);
        }
        public void forgetPassword(View v){
            Navigation.findNavController(v).navigate(R.id.action_loginScreen_to_forgetPasswordScreen);
        }
        public void gotoHome(View v){
            boolean isNetwork = StaticMethods.isConnectingToInternet(getActivity());
            if(!isNetwork){
                binding.nested.setVisibility(View.GONE);
                binding.noNetwork.setVisibility(View.VISIBLE);
            }else {
                if(binding.edEmail.getText().toString().isEmpty()){
                    ToastUtil.showErrorToast(getActivity() , "Enter your email");
                }else if(binding.edPassword.getText().toString().isEmpty()){
                    ToastUtil.showErrorToast(getActivity() , "Enter your password");
                }else {
                    dialog.ShowDialog();
                    presenter.loginFun(getActivity() , binding.edEmail.getText().toString() ,binding.edPassword.getText().toString() );
                }
            }

        }
        public void checkNetwork(View v){
            boolean isNetwork = StaticMethods.isConnectingToInternet(getActivity());
            if(isNetwork){
                binding.nested.setVisibility(View.VISIBLE);
                binding.noNetwork.setVisibility(View.GONE);
            }
        }
    }
}