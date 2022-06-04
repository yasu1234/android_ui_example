package com.example.ui_example.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_example.R

class SimpleRecyclerAdapter(private val titleList: List<String>): RecyclerView.Adapter<SimpleRecyclerAdapter.SimpleListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.simple_list, parent, false)
        return SimpleListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

    override fun onBindViewHolder(holder: SimpleListViewHolder, position: Int) {
        holder.titleTextView.text = titleList[position]
    }

    class SimpleListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView = itemView.findViewById(R.id.simpleListTitleTextView)
    }
}