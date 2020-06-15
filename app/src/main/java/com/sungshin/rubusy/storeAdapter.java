package com.sungshin.rubusy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class storeAdapter extends RecyclerView.Adapter<storeAdapter.storesViewHolder> {
    private ArrayList<StoreModel> arrayList;
    private Context context;

    public storeAdapter(ArrayList<StoreModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public storesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store,parent,false);
        storesViewHolder holder = new storesViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull storesViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getImageId())
                .into(holder.storeImage);
        holder.storeNameText.setText(arrayList.get(position).getStoreName());
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
        holder.crowdText.setText(arrayList.get(position).getCrowdedness());
        holder.operationText.setText(arrayList.get(position).getOperation());

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class storesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView storeImage;
        TextView storeNameText;
        ImageView wifi;
        ImageView call;
        ImageView car;
        ImageView plug;
        ImageView reserve;
        TextView crowdText;
        TextView operationText;

        public storesViewHolder(@NonNull View itemView) {
            super(itemView);
            this.storeImage = itemView.findViewById(R.id.storeImage);
            this.storeNameText = itemView.findViewById(R.id.storeNameText);
            this.wifi = itemView.findViewById(R.id.wifi);
            this.call = itemView.findViewById(R.id.call);
            this.car = itemView.findViewById(R.id.car);
            this.plug = itemView.findViewById(R.id.plug);
            this.reserve = itemView.findViewById(R.id.reserve);
            this.crowdText = itemView.findViewById(R.id.crowdText);
            this.operationText = itemView.findViewById(R.id.operationText);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Toast.makeText(context, "동작완료"+position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, StoreDetailActivity.class);
            context.startActivity(intent);
        }
    }
}
