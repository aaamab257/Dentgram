package com.atcode.dentgram.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentSplashScreenBinding;
import com.atcode.dentgram.helpers.prefs.PrefUtils;
import com.atcode.dentgram.ui.main.MainActivity;
import com.atcode.dentgram.utils.StaticMethods;


public class SplashScreen extends Fragment {

    MyHandler handler;
    View v;
    FragmentSplashScreenBinding binding;
    Handler mHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        StaticMethods.statusBar(getActivity(), "#FFBF41");
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash_screen, container, false);
        v = binding.getRoot();
        handler = new MyHandler(getActivity());
        binding.setHandler(handler);
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(PrefUtils.getUserformation(getActivity())){
                    Navigation.findNavController(v).navigate(R.id.action_splashScreen_to_mainScreen);
                }else {
                    Navigation.findNavController(v).navigate(R.id.action_splashScreen_to_welcomeFragment);
                }


            }
        }, 4000);
        return v;
    }

    public class MyHandler {
        Context context;

        public MyHandler(Context context) {
            this.context = context;
        }

        public void onSplash(View v) {

        }
    }


}