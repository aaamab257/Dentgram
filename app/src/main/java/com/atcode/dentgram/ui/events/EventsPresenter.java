package com.atcode.dentgram.ui.events;

import android.content.Context;

import com.atcode.dentgram.data.EventsData.EventsArray;
import com.atcode.dentgram.data.FeaturedEvents.FeaturedEventArray;
import com.atcode.dentgram.utils.StaticMethods;
import com.atcode.dentgram.utils.network.ConnectionListener;
import com.atcode.dentgram.utils.network.ConnectionResponse;
import com.atcode.dentgram.utils.network.MainApi;
import com.atcode.dentgram.utils.network.MainApiBody;

import okhttp3.RequestBody;

public class EventsPresenter {

    EventsInterface events;

    public EventsPresenter(EventsInterface events) {
        this.events = events;
    }

    public void normalEvents(Context context, int sortedBy) {
        boolean network = StaticMethods.isConnectingToInternet(context);
        if (network) {
            RequestBody body = null;
            try {
                body = MainApiBody.eventsBody(sortedBy);
            } catch (Exception e) {

            }
            MainApi.GetAllEvents(body, new ConnectionListener<EventsArray>() {
                @Override
                public void onSuccess(ConnectionResponse<EventsArray> connectionResponse) {
                    events.onNormalEvents(connectionResponse.data);
                }

                @Override
                public void onFail(Throwable throwable) {
                    events.onFail(throwable.getMessage());
                }
            });
        } else {
            events.onConnection(true);
        }
    }

    public void featuredEvents(Context context ){
        boolean network = StaticMethods.isConnectingToInternet(context);
        if (network) {

            MainApi.GetFeaturedEvents( new ConnectionListener<FeaturedEventArray>() {
                @Override
                public void onSuccess(ConnectionResponse<FeaturedEventArray> connectionResponse) {
                    events.onFeaturedEvents(connectionResponse.data);
                }

                @Override
                public void onFail(Throwable throwable) {
                    events.onFail(throwable.getMessage());
                }
            });
        } else {
            events.onConnection(true);
        }
    }

}
