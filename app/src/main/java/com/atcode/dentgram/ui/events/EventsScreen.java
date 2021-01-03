package com.atcode.dentgram.ui.events;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;

import com.atcode.dentgram.data.EventsData.EventsArray;
import com.atcode.dentgram.data.FeaturedEvents.FeaturedEventArray;
import com.atcode.dentgram.databinding.FragmentEventsScreenBinding;
import com.atcode.dentgram.ui.adapter.FeaturedEvents;
import com.atcode.dentgram.ui.adapter.NormalEvents;
import com.atcode.dentgram.ui.home.MainScreen;
import com.atcode.dentgram.ui.main.MainActivity;
import com.atcode.dentgram.utils.CustomDialog;
import com.atcode.dentgram.utils.dialogs.DialogUtil;
import com.atcode.dentgram.utils.dialogs.DialogUtilResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EventsScreen extends Fragment implements DialogUtilResponse,EventsInterface {

    FragmentEventsScreenBinding binding ;
    View v ;
    FeaturedEvents adapter ;
    EventsHandler handler ;
    CustomDialog dialog ;
    DialogUtil dialogUtil ;
    List<String> sortedBy ;
    int sortedById = 0 ;
    EventsPresenter presenter ;
    NormalEvents normalEventsAdapter ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_events_screen, container, false);
        v = binding.getRoot();
        handler = new EventsHandler(getActivity());
        binding.setHandler(handler);
        sortedBy = Arrays.asList(getResources().getStringArray(R.array.eventsSortedBy));
        dialog = new CustomDialog(getActivity());
        dialogUtil = new DialogUtil(this);
        presenter = new EventsPresenter(this);
        dialog.ShowDialog();
        presenter.normalEvents(getActivity() , sortedById);
        presenter.featuredEvents(getActivity());
        return v;
    }

    @Override
    public void selectedValueSingleChoice(int position) {

    }

    @Override
    public void selectedValueSingleChoice(int position, String arrayType) {
        /*Sort by Date: Earliest*/
        if(arrayType.equals("sortBy")){
            dialog.ShowDialog();
            if (position == 0){
                binding.txtSortedByType.setText("Sort by Date: Latest");
                sortedById = 1 ;
                presenter.normalEvents(getActivity(),sortedById);
            }else if (position == 1 ){
                binding.txtSortedByType.setText("Sort by Date: Earliest");
                sortedById = 2 ;
                presenter.normalEvents(getActivity(),sortedById);
            }else if (position == 2){
                binding.txtSortedByType.setText("Sort by Alphabetic: A-Z");
                sortedById = 3 ;
                presenter.normalEvents(getActivity(),sortedById);
            }else if (position == 3){
                binding.txtSortedByType.setText("Sort by Alphabetic: Z-A");
                sortedById = 4 ;
                presenter.normalEvents(getActivity(),sortedById);
            }
        }
    }

    @Override
    public void selectedMultiChoicelang(ArrayList<String> choices, ArrayList<String> postions, String arrayType) {

    }

    @Override
    public void onFeaturedEvents(FeaturedEventArray featuredEventArray) {
        dialog.DismissDialog();
        adapter = new FeaturedEvents(getActivity() , featuredEventArray);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager.setInitialPrefetchItemCount(5);
        binding.recTopEvents.setLayoutManager(layoutManager);
        binding.recTopEvents.setHasFixedSize(true);
        binding.recTopEvents.setAdapter(adapter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(binding.recTopEvents);
    }

    @Override
    public void onNormalEvents(EventsArray array) {
        //dialog.DismissDialog();
        normalEventsAdapter = new NormalEvents(getActivity() ,array );
        binding.recNormalEvents.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recNormalEvents.setAdapter(normalEventsAdapter);
    }

    @Override
    public void onFail(String fail) {

    }

    @Override
    public void onConnection(boolean isConnected) {

    }

    public class EventsHandler{
        Context context;

        public EventsHandler(Context context) {
            this.context = context;
        }
        public void back(View v){
            ((MainActivity)getActivity()).onBackPressed();
        }

        public void onSortedBy(View v){
            dialogUtil.showDialogSingleChooice(getActivity() ,"Sort By",R.string.ok,sortedBy,"sortBy" );
        }

        public void onSearch(View v){

        }
        public void onFilter(View v){

        }
    }
}