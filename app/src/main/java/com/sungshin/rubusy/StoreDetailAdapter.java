package com.sungshin.rubusy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoreDetailAdapter extends RecyclerView.Adapter<StoreDetailAdapter.ViewHolder> {

    private ArrayList<StoreDetailActivity.item> mDataset; //StoreDetailActivity에 item class를 정의해 놓았음

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // 사용될 항목들 선언
        public TextView tableName_text;
        public TextView tableCount_text;
        public ImageView tableImage_image;

        public ViewHolder(View v) {
            super(v);

            tableName_text = v.findViewById(R.id.tableName);
            tableCount_text = v.findViewById(R.id.tableCount);
            tableImage_image = v.findViewById(R.id.table_Image);
        }
    }

    // 생성자 - 넘어 오는 데이터파입에 유의해야 한다.
    public StoreDetailAdapter(ArrayList<StoreDetailActivity.item> myDataset) {
        mDataset = myDataset;
    }


    //뷰홀더
    // Create new views (invoked by the layout manager)
    @Override
    public StoreDetailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tableName_text.setText(mDataset.get(position).getName());
        holder.tableCount_text.setText(String.valueOf(mDataset.get(position).getCount())+"개"); //int를 가져온다는점 유의
        holder.tableImage_image.setImageResource(mDataset.get(position).getPhoto());
        //holder.mPhoto.setImageBitmap(mDataset.get(position).getPhoto()); //첨부된 이미지를 연결해줘야 하는데 이건 또 복잡하다. 이건 나중에...

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}