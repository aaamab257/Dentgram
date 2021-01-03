package com.atcode.dentgram.ui.promoteAds;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentPromoteYourAdsBinding;


public class PromoteYourAds extends Fragment {

    FragmentPromoteYourAdsBinding binding ;
    View v;
    PromoteHandler handler ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_promote_your_ads, container, false);
        v = binding.getRoot();
        handler = new PromoteHandler(getActivity());
        binding.setHandler(handler);
        return v;
    }

    public class PromoteHandler{
        Context context ;

        public PromoteHandler(Context context) {
            this.context = context;
        }

        public void finish(View v){
            Navigation.findNavController(v).navigate(R.id.action_promoteYourAds_to_mainScreen);
        }
    }
}