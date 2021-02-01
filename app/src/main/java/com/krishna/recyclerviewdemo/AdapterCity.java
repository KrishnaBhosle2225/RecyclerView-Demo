package com.krishna.recyclerviewdemo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCity extends RecyclerView.Adapter<AdapterCity.ViewHolder> {
    Context mContext;
    List<CityName> mCityList;


    public AdapterCity(Context mContext, List<CityName> mCityList) {
        this.mContext = mContext;
        this.mCityList = mCityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cityView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_custom_view, parent, false);

        return new ViewHolder(cityView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CityName citys = mCityList.get(position);

        holder.cityName.setText(citys.getName());

    }

    @Override
    public int getItemCount() {
        return mCityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cityName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.txtViewCity);

            cityName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "City Name is Clicked.", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}