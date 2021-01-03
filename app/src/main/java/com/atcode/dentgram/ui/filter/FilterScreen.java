package com.atcode.dentgram.ui.filter;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentFilterScreenBinding;
import com.atcode.dentgram.ui.main.MainActivity;


public class FilterScreen extends Fragment {


    FragmentFilterScreenBinding binding ;
    View v ;
    FilterHandler handler ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_filter_screen, container, false);
        v = binding.getRoot();
        handler = new FilterHandler(getActivity());
        binding.setHandler(handler);
        return v;
    }

    public class FilterHandler{
        Context context;

        public FilterHandler(Context context) {
            this.context = context;
        }

        public void back(View v){
            ((MainActivity)getActivity()).goToWelcome(v);
        }
    }
}