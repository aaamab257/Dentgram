package com.atcode.dentgram.ui.newsFeeds;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentNewFeedsBinding;
import com.atcode.dentgram.ui.main.MainActivity;


public class NewFeeds extends Fragment {

    FragmentNewFeedsBinding binding ;
    View v ;
    NewFeed handler ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_feeds, container, false);
        v = binding.getRoot();
        handler = new NewFeed(getActivity());
        binding.setHandler(handler);
        return v;
    }

    public class NewFeed{
        Context context ;

        public NewFeed(Context context) {
            this.context = context;
        }

        public void back(View v){
            ((MainActivity)getActivity()).goToWelcome(v);
        }
    }
}