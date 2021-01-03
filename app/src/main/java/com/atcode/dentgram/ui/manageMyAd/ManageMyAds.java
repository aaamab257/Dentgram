package com.atcode.dentgram.ui.manageMyAd;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentManageMyAdsBinding;
import com.atcode.dentgram.ui.main.MainActivity;
//binding = DataBindingUtil.inflate(inflater, R.layout.fragment_buyandsell_screen, container, false);
// v = binding.getRoot();

public class ManageMyAds extends Fragment {


    FragmentManageMyAdsBinding binding;
    View v;
    ManageMyAdsHandler handler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_manage_my_ads, container, false);
        v = binding.getRoot();
        handler = new ManageMyAdsHandler(getActivity());
        binding.setHandler(handler);
        return v;
    }

    public class ManageMyAdsHandler {
        Context context;

        public ManageMyAdsHandler(Context context) {
            this.context = context;
        }

        public void addNewAds(View v) {
            Navigation.findNavController(v).navigate(R.id.action_manageMyAds_to_addAdProduct);
        }

        public void back(View v) {
            ((MainActivity) getActivity()).goToWelcome(v);
        }
    }
}