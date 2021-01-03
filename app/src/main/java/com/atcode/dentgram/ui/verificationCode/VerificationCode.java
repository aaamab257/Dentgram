package com.atcode.dentgram.ui.verificationCode;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.data.verifications.VerificationResponse;
import com.atcode.dentgram.databinding.FragmentVerificationCodeBinding;
import com.atcode.dentgram.utils.CustomDialog;
import com.atcode.dentgram.utils.StaticMethods;
import com.atcode.dentgram.utils.ToastUtil;
import com.atcode.dentgram.utils.network.MainApiBody;

import okhttp3.RequestBody;

import static android.content.ContentValues.TAG;


public class VerificationCode extends Fragment implements VerificationListener {

    FragmentVerificationCodeBinding binding ;
    View v ;
    VerificationHandler handler ;
    CustomDialog dialog ;
    VerificationPresenter presenter;
    String userId = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_verification_code, container, false);
        v = binding.getRoot();
        handler = new VerificationHandler(getActivity());
        binding.setHandler(handler);
        dialog = new CustomDialog(getActivity());
        presenter = new VerificationPresenter(this);
        getCode();
        getBun();
        return v;
    }

    private void getBun() {
        userId = getArguments().getString("userId");
    }

    @Override
    public void onVerifySuccess(VerificationResponse response) {

    }

    @Override
    public void onVerifyFail(String code) {

    }

    @Override
    public void onConnection(boolean isConnected) {

    }

    public class VerificationHandler{
        Context context ;

        public VerificationHandler(Context context) {
            this.context = context;
        }

        public void verify(View v){
            String code = "";
            dialog.ShowDialog();
            code = binding.edNum1.getText().toString()+binding.edNum2.getText().toString()+binding.edNum3.getText().toString()+binding.edNum4.getText().toString();
            if (code.length() < 4){
                dialog.DismissDialog();
                ToastUtil.showErrorToast(getActivity(),  "Enter a valid code");
            }else {
                RequestBody body = null ;
                try {
                    body = MainApiBody.verificationCode(userId ,code);
                }catch (Exception e){

                }
                presenter.verify(body , getActivity());
            }
        }
    }

    private void getCode() {
        binding.edNum1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (i2 < i1) {
                    Log.e(TAG, "beforeTextChanged Character deleted" + "/ i=" + i + "/ i1" + i1 + "/ i2" + i2);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.edNum1.getText().toString().length() == 1)     //size as per your requirement
                {
                    binding.edNum2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.edNum2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (i2 < i1) {
                    Log.e(TAG, "beforeTextChanged Character deleted" + "/ i=" + i + "/ i1" + i1 + "/ i2" + i2);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.edNum2.getText().toString().length() == 1)     //size as per your requirement
                {
                    binding.edNum3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.edNum3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (i2 < i1) {
                    Log.e(TAG, "beforeTextChanged Character deleted" + "/ i=" + i + "/ i1" + i1 + "/ i2" + i2);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.edNum3.getText().toString().length() == 1)     //size as per your requirement
                {
                    binding.edNum4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.edNum4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (i2 < i1) {
                    Log.e(TAG, "beforeTextChanged Character deleted" + "/ i=" + i + "/ i1" + i1 + "/ i2" + i2);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.edNum4.getText().toString().length() == 1)     //size as per your requirement
                {
                    StaticMethods.hideKeyboard(getActivity());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}