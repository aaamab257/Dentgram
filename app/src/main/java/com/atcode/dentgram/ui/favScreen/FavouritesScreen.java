package com.atcode.dentgram.ui.favScreen;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentFavouritesScreenBinding;
import com.atcode.dentgram.ui.home.MainScreen;
import com.atcode.dentgram.ui.main.MainActivity;


public class FavouritesScreen extends Fragment {


    MyFav handler ;
    View v ;
    FragmentFavouritesScreenBinding binding ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourites_screen, container, false);
        handler = new MyFav(getActivity());
        binding.setHandler(handler);
        v = binding.getRoot();
        return v;
    }

    public class MyFav{
        Context context ;

        public MyFav(Context context) {
            this.context = context;
        }

        public void back(View v){
            ((MainActivity)getActivity()).goToWelcome(v);
        }
    }
}