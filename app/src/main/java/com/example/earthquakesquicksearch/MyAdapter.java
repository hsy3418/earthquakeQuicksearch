package com.example.earthquakesquicksearch;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.earthquakesquicksearch.databinding.Earthquake;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.w3c.dom.Text;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

    private List<Earthquake> earthquakeList;


    public MyAdapter(List<Earthquake> earthquakeList) {
        this.earthquakeList = earthquakeList;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvPlace;
        public TextView tvTime;
        public TextView tvMagnitude;


        public MyViewHolder(View itemView) {
            super(itemView);
            tvPlace = itemView.findViewById(R.id.placeTv);
            tvTime = itemView.findViewById(R.id.timeTv);
            tvMagnitude = itemView.findViewById(R.id.magTv);


        }
    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        Context context = parent.getContext();
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.earthquakeview, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int position) {
        Earthquake earthquake = earthquakeList.get(position);
        TextView tvPlace = myViewHolder.tvPlace;
        tvPlace.setText(earthquake.getPlace());
        TextView tvTime = myViewHolder.tvTime;

        // convert millis value to a timezone
        Instant instant = Instant.ofEpochMilli(Long.parseLong(earthquake.getTime()));
        ZonedDateTime z = instant.atZone(ZoneId.of("Australia/Sydney"));
// format it
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd/ hh:mm ");


        tvTime.setText(fmt.format(z));
        TextView tvMag = myViewHolder.tvMagnitude;
        tvMag.setText(earthquake.getMagnitude());

    }

    @Override
    public int getItemCount() {
        return earthquakeList.size();
    }
}
