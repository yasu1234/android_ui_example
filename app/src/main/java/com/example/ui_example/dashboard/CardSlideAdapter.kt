package com.example.ui_example.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_example.R

class CardSlideAdapter(private val countList: List<Int>): RecyclerView.Adapter<CardSlideAdapter.cardListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.slide_card, parent, false)
        return cardListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countList.size
    }

    override fun onBindViewHolder(holder: cardListViewHolder, position: Int) {
        holder.cardText.text = countList[position].toString()
    }

    class cardListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardText: TextView = itemView.findViewById(R.id.cardTextView)
    }
}