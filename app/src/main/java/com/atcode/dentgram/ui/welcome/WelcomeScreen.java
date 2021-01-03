package com.atcode.dentgram.ui.welcome;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.PagerAdapter;

import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atcode.dentgram.R;
import com.atcode.dentgram.databinding.FragmentWelcomeBinding;
import com.atcode.dentgram.utils.StaticMethods;

import java.util.Timer;
import java.util.TimerTask;


public class WelcomeScreen extends Fragment {


    FragmentWelcomeBinding binding ;
    View v ;
    MyHandler handler ;
    private int[] layouts;
    MyViewPagerAdapter adapter ;
    private TextView[] dots;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        StaticMethods.statusBar(getActivity(), "#FFFFFF");
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false);
        v = binding.getRoot();
        handler = new MyHandler(getActivity());
        binding.setHandler(handler);
        initialViews();
        putDelay();
        return v;
    }

    private void putDelay() {
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == layouts.length) {
                    currentPage = 0;
                }
                binding.viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }

    public class MyHandler{
        Context context ;

        public MyHandler(Context context) {
            this.context = context;
        }

        public void getStarted(View v){
            Navigation.findNavController(v).navigate(R.id.action_welcomeFragment_to_loginScreen);
        }
    }
    private void initialViews() {

        layouts = new int[]{
                R.layout.welcome_one,
                R.layout.welcome_two,
                R.layout.welcome_three
        };
        addBottomDots(0);
        adapter = new MyViewPagerAdapter();
        binding.viewPager.setAdapter(adapter);
        binding.viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

    }
    androidx.viewpager.widget.ViewPager.OnPageChangeListener viewPagerPageChangeListener = new androidx.viewpager.widget.ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };
    private void addBottomDots(int i) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        binding.layoutDots.removeAllViews();
        for (int j = 0; j < dots.length; j++) {
            dots[j] = new TextView(getActivity());
            dots[j].setText(Html.fromHtml("&#8226;"));
            dots[j].setTextSize(30);
            dots[j].setTextColor(colorsInactive[j]);
            binding.layoutDots.addView(dots[j]);
        }

        if (dots.length > 0)
            dots[i].setTextColor(colorsActive[i]);
    }
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

}