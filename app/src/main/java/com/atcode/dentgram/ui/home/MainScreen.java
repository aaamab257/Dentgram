package com.atcode.dentgram.ui.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentMainScreenBinding;
import com.atcode.dentgram.helpers.prefs.PrefUtils;
import com.atcode.dentgram.utils.StaticMethods;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;


public class MainScreen extends Fragment {



    FragmentMainScreenBinding binding ;
    View v ;
    BottomSheetBehavior sheetBehavior;
    MainHandler handler ;
    NavigationView nav;
    View header;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StaticMethods.statusBar(getActivity(), "#0B4980");
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false);
        v = binding.getRoot();
        handler = new MainHandler(getActivity());
        binding.setHandler(handler);
        init();
        sheetBehavior = BottomSheetBehavior.from(binding.layoutBottomSheet);

        return v;
    }

    private void init() {
        nav = binding.navigation;
        header = nav.getHeaderView(0);
        ConstraintLayout about = header.findViewById(R.id.cons_about);
        ConstraintLayout fav = header.findViewById(R.id.cons_fav);
        ConstraintLayout contact = header.findViewById(R.id.cons_contact);
        ConstraintLayout newFeeds = header.findViewById(R.id.cons_newFeed);
        CardView matchmaking = header.findViewById(R.id.cons_match);
        ConstraintLayout events = header.findViewById(R.id.cons_events);
        ConstraintLayout logout = header.findViewById(R.id.cons_logout);//cons_logout
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainScreen_to_aboutScreen);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainScreen_to_favouritesScreen);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainScreen_to_contactUsScreen);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        newFeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainScreen_to_newFeeds);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        matchmaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainScreen_to_matchmaking);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_mainScreen_to_eventsScreen2);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StaticMethods.ClearChash();
                PrefUtils.SignOut_User(getActivity());
                Navigation.findNavController(v).navigate(R.id.action_mainScreen_to_loginScreen);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    public class MainHandler{
        Context context ;

        public MainHandler(Context context) {
            this.context = context;
        }
        public void toggleBottomSheet(View v){
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        }

        public void close(View view){
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        }
        public void drawer(View view) {
            if (!binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
        }
        public void  onSearch(View v){
            Navigation.findNavController(v).navigate(R.id.action_mainScreen_to_searchScreen);
        }

        public void newsFeed(View v){
            Navigation.findNavController(v).navigate(R.id.action_mainScreen_to_newFeeds);
        }
    }
}