package com.atcode.dentgram.ui.matchmakingPage;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentMatchmakingBinding;
import com.atcode.dentgram.ui.main.MainActivity;


public class Matchmaking extends Fragment {



    FragmentMatchmakingBinding binding ;
    View v ;
    MatchmackingHandler handler ;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_matchmaking, container, false);
        handler = new MatchmackingHandler(getActivity());
        v = binding.getRoot();
        binding.setHandler(handler);
        return v;


    }

    public  class  MatchmackingHandler{
        Context context ;

        public MatchmackingHandler(Context context) {
            this.context = context;
        }
        public void onBack(View v){
            ((MainActivity)getActivity()).goToWelcome(v);
        }
        public void onFindClick(View v){

        }
        public void onB2BClick(View v){

        }
        public void onBuildingClick(View v){

        }
    }
}