package com.atcode.dentgram.ui.events;

import com.atcode.dentgram.data.EventsData.EventsArray;
import com.atcode.dentgram.data.FeaturedEvents.FeaturedEventArray;

public interface EventsInterface {
   void onFeaturedEvents(FeaturedEventArray featuredEventArray);
   void onNormalEvents(EventsArray array);
   void onFail(String fail);
   void onConnection(boolean isConnected);
}
