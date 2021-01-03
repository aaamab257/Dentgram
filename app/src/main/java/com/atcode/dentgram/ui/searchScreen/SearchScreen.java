package com.atcode.dentgram.ui.searchScreen;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentSearchScreenBinding;
import com.atcode.dentgram.ui.main.MainActivity;


public class SearchScreen extends Fragment {


    FragmentSearchScreenBinding binding ;
    View v ;
    SearchHandler handler ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_screen, container, false);
        v = binding.getRoot();
        handler = new SearchHandler(getActivity());
        binding.setHandler(handler);
        return v;
    }

    public class SearchHandler{
        Context context ;

        public SearchHandler(Context context) {
            this.context = context;
        }

        public void onCancel(View v){
            ((MainActivity)getActivity()).goToWelcome(v);
        }
    }
}