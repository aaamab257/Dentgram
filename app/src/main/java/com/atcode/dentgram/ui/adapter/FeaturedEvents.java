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
import com.atcode.dentgram.data.Favo.FavResponse;
import com.atcode.dentgram.data.FeaturedEvents.FeaturedEventArray;
import com.atcode.dentgram.utils.StaticMethods;
import com.atcode.dentgram.utils.ToastUtil;
import com.atcode.dentgram.utils.network.ConnectionListener;
import com.atcode.dentgram.utils.network.ConnectionResponse;
import com.atcode.dentgram.utils.network.MainApi;
import com.atcode.dentgram.utils.network.MainApiBody;

import okhttp3.RequestBody;

public class FeaturedEvents extends RecyclerView.Adapter<FeaturedEvents.MyViewHolder> {
    private LayoutInflater mInflater;
    Context context ;
    FeaturedEventArray array ;
    String[] des = {"Event 1" , "Event 2" , "Event 3" ,"Event 4"};

    public FeaturedEvents(Context context, FeaturedEventArray array) {
        this.context = context;
        this.array = array;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.events_top_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.description.setText(array.getResult().get(position).getDetails());
        holder.date.setText(array.getResult().get(position).getViewDate());
        holder.location.setText(array.getResult().get(position).getLocation());
        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callFavApi(array.getResult().get(position).getId());
            }


        });
        //Picasso.get().load(array.getResult().get(position).getImage()).into(holder.img);
    }
    private void callFavApi(int id) {
        boolean network = StaticMethods.isConnectingToInternet(context);
        if(network){
            RequestBody body = null;
            try {
                body = MainApiBody.addEventToFav(id);
            }catch (Exception e){

            }
            MainApi.addFav(body, new ConnectionListener<FavResponse>() {
                @Override
                public void onSuccess(ConnectionResponse<FavResponse> connectionResponse) {
                    ToastUtil.showSuccessToast(context , "Added to favorite");
                }

                @Override
                public void onFail(Throwable throwable) {
                    ToastUtil.showErrorToast(context , "Server Error please try again");
                }
            });
        }else {
            ToastUtil.showErrorToast(context , "No Internet Connection");
        }
    }
    @Override
    public int getItemCount() {
        return array.getResult().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView description , date ,location ;
        ImageView img , fav ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.txt_eventDes);
            date = itemView.findViewById(R.id.txt_eventDate);
            location = itemView.findViewById(R.id.txt_eventDateBottom);
            img = itemView.findViewById(R.id.img_event);
            fav = itemView.findViewById(R.id.img_fav);
        }
    }
}
