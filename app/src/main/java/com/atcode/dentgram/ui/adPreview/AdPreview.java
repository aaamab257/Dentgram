package com.atcode.dentgram.ui.adPreview;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentAdPreviewBinding;
import com.atcode.dentgram.ui.main.MainActivity;


public class AdPreview extends Fragment {

    FragmentAdPreviewBinding binding ;
    View v ;
    AdPreviewHandler handler ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ad_preview, container, false);
        v = binding.getRoot();
        handler = new AdPreviewHandler(getActivity());
        binding.setHandler(handler);
        return v;
    }
    public class AdPreviewHandler{
        Context context ;

        public AdPreviewHandler(Context context) {
            this.context = context;
        }

        public void next(View v){
            Navigation.findNavController(v).navigate(R.id.action_adPreview_to_promoteYourAds);
        }
        public void edit(View v){
            Navigation.findNavController(v).navigate(R.id.action_adPreview_to_addAdProduct);
        }
        public void back(View v){
            ((MainActivity)getActivity()).goToWelcome(v);
        }
    }
}