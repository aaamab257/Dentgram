package com.atcode.dentgram.ui.forgetPassword;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.data.ForgetPasswordData.ForgetObject;
import com.atcode.dentgram.data.ForgetPasswordData.ForgetPasswordModel;
import com.atcode.dentgram.databinding.FragmentForgetPasswordScreenBinding;
import com.atcode.dentgram.utils.CustomDialog;
import com.atcode.dentgram.utils.ToastUtil;
import com.atcode.dentgram.utils.network.MainApiBody;

import okhttp3.RequestBody;


public class ForgetPasswordScreen extends Fragment implements ForgetPassword {


    FragmentForgetPasswordScreenBinding binding;
    View v;
    ForgetPasswordHandler handler;
    CustomDialog dialog;
    ForgetPasswordPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forget_password_screen, container, false);
        v = binding.getRoot();
        handler = new ForgetPasswordHandler(getActivity());
        dialog = new CustomDialog(getActivity());
        presenter = new ForgetPasswordPresenter(this);
        binding.setHandler(handler);

        return v;
    }



    @Override
    public void onForgetSuccess(ForgetObject<ForgetPasswordModel> forget) {
        Bundle b = new Bundle();
        b.putString("userId", forget.result.getUserId());
        Navigation.findNavController(v).navigate(R.id.action_forgetPasswordScreen_to_createNewPassword, b);
        dialog.DismissDialog();
    }

    @Override
    public void onForgetFail(String code) {
        dialog.DismissDialog();
    }

    @Override
    public void onConnection(boolean isConnected) {
        dialog.DismissDialog();
    }

    public class ForgetPasswordHandler {
        Context context;

        public ForgetPasswordHandler(Context context) {
            this.context = context;
        }

        public void onNext(View v) {
            dialog.ShowDialog();
            if (binding.edEmailForget.getText().toString().isEmpty()) {
                dialog.DismissDialog();
                ToastUtil.showErrorToast(getActivity(), "Enter your email");
            } else if (binding.edPhoneForget.getText().toString().isEmpty()) {
                dialog.DismissDialog();
                ToastUtil.showErrorToast(getActivity(), "Enter your phone");
            } else {
                RequestBody body = null;
                try {
                    body = MainApiBody.forgetPassword(binding.edEmailForget.getText().toString(), binding.edPhoneForget.getText().toString());
                } catch (Exception e) {

                }
                presenter.forgetApi(getActivity(), body);
            }

        }
    }
}