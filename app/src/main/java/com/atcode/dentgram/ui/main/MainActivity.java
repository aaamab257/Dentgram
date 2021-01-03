package com.atcode.dentgram.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.ActivityMainBinding;
import com.atcode.dentgram.ui.welcome.WelcomeScreen;
import com.atcode.dentgram.utils.IntentUtilies;
import com.atcode.dentgram.utils.StaticMethods;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainHandler handler;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handler = new MainHandler(this);
        navController = Navigation.findNavController(this, R.id.fragment);
        binding.setHandler(handler);
    }

    public void goToWelcome(View view) {
        onBackPressed();
    }


    public class MainHandler {
        Context context;

        public MainHandler(Context context) {
            this.context = context;
        }
    }

    public void addToCalender() {
        Calendar calendarEvent = Calendar.getInstance();
        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        i.putExtra("beginTime", calendarEvent.getTimeInMillis());
        i.putExtra("allDay", true);
        i.putExtra("rule", "FREQ=YEARLY");
        i.putExtra("endTime", calendarEvent.getTimeInMillis() + 60 * 60 * 1000);
        i.putExtra("title", "Calendar Event");
        startActivity(i);

    }

}