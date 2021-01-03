package com.atcode.dentgram.ui.contactUs;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentContactUsScreenBinding;
import com.atcode.dentgram.ui.main.MainActivity;


public class ContactUsScreen extends Fragment {

    FragmentContactUsScreenBinding binding ;
    View v ;
    ContactUs handler ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_us_screen, container, false);
        v = binding.getRoot();
        handler = new ContactUs(getActivity());
        binding.setHandler(handler);
        return v;
    }

    public class ContactUs{
        Context context ;

        public ContactUs(Context context) {
            this.context = context;
        }
        public void back(View v){
            ((MainActivity)getActivity()).goToWelcome(v);
        }
    }
}