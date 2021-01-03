package com.atcode.dentgram.ui.eventDes;

import com.atcode.dentgram.data.EventById.EventData;
import com.atcode.dentgram.data.EventById.EventObject;

public interface EventsDesInterface {
    void onEventSuccess(EventObject<EventData> data);
    void onConnection(boolean isConnected);
    void onEventFailed(String error);

}
