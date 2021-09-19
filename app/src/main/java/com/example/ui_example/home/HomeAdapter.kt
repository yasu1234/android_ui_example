package com.example.ui_example.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_example.R

class HomeAdapter(private val countList: List<Int>): RecyclerView.Adapter<HomeAdapter.countListRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.countListRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.grid_list, parent, false)
        return countListRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countList.size
    }

    override fun onBindViewHolder(holder: countListRecyclerViewHolder, position: Int) {
        holder.countText.text = countList[position].toString()
    }

    class countListRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countText: TextView = itemView.findViewById(R.id.gridTextView)
    }
}