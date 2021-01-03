package com.atcode.dentgram.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.atcode.dentgram.R;
import com.atcode.dentgram.ui.main.MainActivity;
import com.atcode.dentgram.utils.StaticMethods;


public class AboutScreen extends Fragment {


    View v;
    ImageView imgBack ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        StaticMethods.statusBar(getActivity(), "#0B4980");
        v = inflater.inflate(R.layout.fragment_about_screen, container, false);
        imgBack = v.findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).goToWelcome(v);
            }
        });
        return v;
    }
}