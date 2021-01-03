package com.atcode.dentgram.ui.eventDes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atcode.dentgram.R;
import com.atcode.dentgram.data.EventById.EventData;
import com.atcode.dentgram.data.EventById.EventObject;
import com.atcode.dentgram.databinding.FragmentEventsDescriptionBinding;
import com.atcode.dentgram.ui.adapter.SpeakersAdapter;
import com.atcode.dentgram.ui.main.MainActivity;
import com.atcode.dentgram.utils.CustomDialog;
import com.atcode.dentgram.utils.ToastUtil;
import com.atcode.dentgram.utils.network.MainApiBody;

import okhttp3.RequestBody;


public class EventsDescription extends Fragment implements EventsDesInterface {

    FragmentEventsDescriptionBinding binding;
    View v ;
    int id = 0 ;
    EventDesHandler handler ;
    CustomDialog dialog ;
    SpeakersAdapter adapter ;
    EventDesPresenter presenter ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_events_description, container, false);
        v = binding.getRoot();
        handler = new EventDesHandler(getActivity());
        binding.setHandler(handler);
        presenter = new EventDesPresenter(this);

        dialog = new CustomDialog(getActivity());
        try {
            id = getArguments().getInt("id");
        }catch (Exception e){

        }
        dialog.ShowDialog();
        RequestBody body = null ;
        try {
            body = MainApiBody.eventById(id);
        }catch (Exception e){

        }
        presenter.getEventDetails(getActivity() , body);
        return v;
    }

    @Override
    public void onEventSuccess(EventObject<EventData> data) {
        dialog.DismissDialog();
        binding.txtEventDate.setText(data.result.getViewDate());
        binding.txtEventDateBottom.setText(data.result.getViewDate());
        binding.txtEventDes.setText(data.result.getTitle());
        binding.txtEventLocation.setText(data.result.getLocation());
        binding.txtEventsDetails.setText(data.result.getDetails());
        binding.txtEventLocationBottom.setText(data.result.getLocation());
        binding.txtHostedBy.setText(data.result.getHostedBy());
        binding.txtToolbarTitle.setText(data.result.getTitle());
        adapter = new SpeakersAdapter( data.result,getActivity() );
        binding.recSpeakers.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recSpeakers.setAdapter(adapter);
    }

    @Override
    public void onConnection(boolean isConnected) {
        dialog.DismissDialog();
        ToastUtil.showErrorToast(getActivity() , "No internet connection");
    }

    @Override
    public void onEventFailed(String error) {
        dialog.DismissDialog();
        ToastUtil.showErrorToast(getActivity() , "Server Error please try again");
    }

    public class EventDesHandler{
        Context context ;

        public EventDesHandler(Context context) {
            this.context = context;
        }

        public void addCalender(View v){

            ((MainActivity)getActivity()).addToCalender();
        }
    }

}