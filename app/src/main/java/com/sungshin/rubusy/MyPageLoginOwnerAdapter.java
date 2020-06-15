package com.sungshin.rubusy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyPageLoginOwnerAdapter extends RecyclerView.Adapter<MyPageLoginOwnerAdapter.MyViewHolder>{
    Context context;
    ArrayList<MyPageLoginOwnerItem> list;

    public MyPageLoginOwnerAdapter(Context context, ArrayList<MyPageLoginOwnerItem> list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.image.setImageResource(list.get(position).my_page_login_owner_icon);
        holder.name.setText(list.get(position).my_page_login_owner_name);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_mypageloginowner_recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.mypagelogOwner_button);
            name = itemView.findViewById(R.id.mypagelogOwner_name);
        }
    }

}