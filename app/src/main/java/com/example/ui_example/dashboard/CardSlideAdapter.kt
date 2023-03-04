package com.example.ui_example.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_example.R

class CardSlideAdapter(private val countList: List<Int>): RecyclerView.Adapter<CardSlideAdapter.CardListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.slide_card, parent, false)
        return CardListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countList.size
    }

    override fun onBindViewHolder(holder: CardListViewHolder, position: Int) {
        // lineSpacingMultiplier is ratio to word
        if (position == 0) {
            holder.cardText.text = countList[position].toString() + "これはlineSpacingExtraを30spに設定しています。改行して設定が反映できているかを判定します。"
        } else {
            holder.cardText.text = countList[position].toString()
        }
    }

    class CardListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardText: TextView = itemView.findViewById(R.id.cardTextView)
    }
}