package com.atcode.dentgram;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.databinding.FragmentLoadingScreenBinding;
import com.atcode.dentgram.utils.StaticMethods;


public class LoadingScreen extends Fragment {



    FragmentLoadingScreenBinding binding ;
    View v ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        StaticMethods.statusBar(getActivity(), "#FFFFFF");
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_loading_screen, container, false);
        v = binding.getRoot();

        return v;
    }

    @Override
    public void onResume() {
        binding.mShimmerViewContainer.startShimmerAnimation();
        super.onResume();
    }

    @Override
    public void onPause() {
        binding.mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }
}