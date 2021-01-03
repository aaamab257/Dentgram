package com.atcode.dentgram.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atcode.dentgram.R;
import com.atcode.dentgram.data.EventById.EventData;
import com.atcode.dentgram.data.EventById.EventObject;
import com.squareup.picasso.Picasso;

public class SpeakersAdapter extends RecyclerView.Adapter<SpeakersAdapter.MyViewHolder> {
    EventData data ;
    Context context ;
    private LayoutInflater mInflater;

    public SpeakersAdapter(EventData data, Context context) {
        this.data = data;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SpeakersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.speakers_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeakersAdapter.MyViewHolder holder, int position) {
        holder.name.setText(data.getSpeakers().get(position).getName());
        holder.des.setText(data.getSpeakers().get(position).getTitle());
        //Picasso.get().load(data.getSpeakers().get(position).getImage()).into(holder.speakerImg);
    }

    @Override
    public int getItemCount() {
        return data.getSpeakers().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name , des ;
        ImageView speakerImg ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);
            des = itemView.findViewById(R.id.txt_jopTitle);
            speakerImg = itemView.findViewById(R.id.user_image);
        }
    }
}
