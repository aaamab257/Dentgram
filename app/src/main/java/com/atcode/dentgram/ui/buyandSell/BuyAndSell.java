package com.atcode.dentgram.ui.buyandSell;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentBuyandsellScreenBinding;
import com.atcode.dentgram.databinding.FragmentBuyandsellScreenBinding;
import com.atcode.dentgram.ui.main.MainActivity;

public class BuyAndSell extends Fragment {

    FragmentBuyandsellScreenBinding binding ;
    View v ;
    MyEventHandler handler ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_buyandsell_screen, container, false);
        v = binding.getRoot();
        handler = new MyEventHandler(getActivity());
        binding.setHandler(handler);
        return v;
    }

    public class MyEventHandler{
        Context context ;

        public MyEventHandler(Context context) {
            this.context = context;
        }

        public void myAds(View v ){
            Navigation.findNavController(v).navigate(R.id.action_eventsScreen_to_manageMyAds);
        }
        public void back(View v){
            ((MainActivity)getActivity()).goToWelcome(v);
        }
        public void  onFilter(View v){
            Navigation.findNavController(v).navigate(R.id.action_eventsScreen_to_filterScreen);
        }
        public void  onSearch(View v){
            Navigation.findNavController(v).navigate(R.id.action_eventsScreen_to_searchScreen);
        }
    }
}