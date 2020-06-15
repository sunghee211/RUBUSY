package com.sungshin.rubusy;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private ArrayList<Store> arrayList;
    private Context context;

    public CategoryAdapter(ArrayList<Store> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recyclerview_convenience,parent,false);
        CategoryViewHolder holder = new CategoryViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getCall())
                .into(holder.call);
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getCar())
                .into(holder.car);
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getWifi())
                .into(holder.wifi);
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getPlug())
                .into(holder.plug);
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getReservation())
                .into(holder.reserve);
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView wifi;
        ImageView call;
        ImageView car;
        ImageView plug;
        ImageView reserve;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.wifi = itemView.findViewById(R.id.wifi);
            this.call = itemView.findViewById(R.id.call);
            this.car = itemView.findViewById(R.id.car);
            this.plug = itemView.findViewById(R.id.plug);
            this.reserve = itemView.findViewById(R.id.reserve);
        }
    }
}
