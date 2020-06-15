//package com.sungshin.rubusy;
//
//import android.content.Context;
//import android.media.Image;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//
//import java.util.ArrayList;
//
//public class CategoryAdapter2 extends RecyclerView.Adapter<CategoryAdapter2.CategoryViewHolder> {
//    private ArrayList<Store> arrayList;
//    private Context context;
//
//    public CategoryAdapter2(ArrayList<Store> arrayList, Context context) {
//        this.arrayList = arrayList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
//        CategoryAdapter2.CategoryViewHolder holder = new CategoryAdapter2.CategoryViewHolder(view);
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
//        Glide.with(holder.itemView)
//                .load(arrayList.get(position).getTableImage())
//                .into(holder.table_Image);
//        holder.tableCount.setText(arrayList.get(position).getTable());
//    }
//
//    @Override
//    public int getItemCount() {
//        return (arrayList != null ? arrayList.size() : 0);
//    }
//
//    public class CategoryViewHolder extends RecyclerView.ViewHolder {
//        TextView tableCount;
//        ImageView table_Image;
//
//        public CategoryViewHolder(@NonNull View itemView) {
//            super(itemView);
//            this.tableCount = itemView.findViewById(R.id.tableCount);
//            this.table_Image = itemView.findViewById(R.id.table_Image);
//        }
//    }
//}
