package com.atcode.dentgram.ui.addAdProd;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentAddAdProductBinding;
import com.atcode.dentgram.ui.main.MainActivity;


public class AddAdProduct extends Fragment {

    FragmentAddAdProductBinding binding;
    View v;
    MyAddAdProductHandler handler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_ad_product, container, false);
        v = binding.getRoot();
        handler = new MyAddAdProductHandler(getActivity());
        binding.setHandler(handler);
        return v;
    }

    public class MyAddAdProductHandler {
        Context context;

        public MyAddAdProductHandler(Context context) {
            this.context = context;
        }

        public void next(View v) {
            Navigation.findNavController(v).navigate(R.id.action_addAdProduct_to_adPreview);
        }

        public void preview(View v) {
            Navigation.findNavController(v).navigate(R.id.action_addAdProduct_to_adPreview);
        }
        public void close(View v){
            ((MainActivity)getActivity()).goToWelcome(v);
        }
    }
}