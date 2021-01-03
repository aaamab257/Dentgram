package com.atcode.dentgram.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.atcode.dentgram.R;
import com.atcode.dentgram.data.EventsData.EventsArray;

public class NormalEvents extends RecyclerView.Adapter<NormalEvents.MyViewHolder> {
    Context context ;
    EventsArray array ;
    private LayoutInflater mInflater;

    public NormalEvents(Context context, EventsArray array) {
        this.context = context;
        this.array = array;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.event_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtDes.setText(array.getEvents().get(position).getTitle());
        holder.txtDate.setText(array.getEvents().get(position).getViewDate());
        holder.txtLocation.setText(array.getEvents().get(position).getLocation());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt("id" , array.getEvents().get(position).getId());
                Navigation.findNavController(v).navigate(R.id.action_eventsScreen2_to_eventsDescription , b);
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.getEvents().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtLocation , txtDes , txtDate ;
        ImageView imgEvent ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtLocation = itemView.findViewById(R.id.txt_eventLocation);
            txtDes = itemView.findViewById(R.id.txt_eventDes);
            txtDate = itemView.findViewById(R.id.txt_eventDate);
            imgEvent = itemView.findViewById(R.id.img_event);
        }
    }
}
