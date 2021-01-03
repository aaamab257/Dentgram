package com.atcode.dentgram.ui.eventDes;

import android.content.Context;

import com.atcode.dentgram.data.EventById.EventData;
import com.atcode.dentgram.data.EventById.EventObject;
import com.atcode.dentgram.utils.StaticMethods;
import com.atcode.dentgram.utils.network.ConnectionListener;
import com.atcode.dentgram.utils.network.ConnectionResponse;
import com.atcode.dentgram.utils.network.MainApi;

import okhttp3.RequestBody;

public class EventDesPresenter {
    EventsDesInterface event ;

    public EventDesPresenter(EventsDesInterface event) {
        this.event = event;
    }

    public void getEventDetails(Context context , RequestBody body ){
        boolean network = StaticMethods.isConnectingToInternet(context);
        if(network){
            MainApi.getEventDetails(body, new ConnectionListener<EventObject<EventData>>() {
                @Override
                public void onSuccess(ConnectionResponse<EventObject<EventData>> connectionResponse) {
                    event.onEventSuccess(connectionResponse.data);
                }

                @Override
                public void onFail(Throwable throwable) {
                    event.onEventFailed(throwable.getMessage());
                }
            });
        }else {
            event.onConnection(true);
        }
    }
}
