package com.sungshin.rubusy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_review.view.*

class ReviewDataAdapter (val list:List<ReviewModel>): RecyclerView.Adapter<ReviewDataViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_review,parent,false)
        return ReviewDataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ReviewDataViewHolder, position: Int) {
        holder.containerView.reviewImage.setImageResource(list[position].reviewImageId)
        holder.containerView.reviewSubject.text = list[position].reviewSubject
        holder.containerView.reviewText.text = list[position].reviewText
        holder.containerView.ratingBar.setRating(list[position].reviewPoint)
        holder.containerView.ratingValue.text = "${list[position].reviewPoint}"

    }


}