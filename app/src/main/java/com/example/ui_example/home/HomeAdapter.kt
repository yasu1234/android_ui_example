package com.example.ui_example.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_example.R
import com.example.ui_example.tutorial.TutorialLastFragment

class HomeAdapter(private val countList: List<Int>): RecyclerView.Adapter<HomeAdapter.CountListRecyclerViewHolder>() {
    private lateinit var listner: HomeAdapterListner
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.CountListRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.grid_list, parent, false)
        return CountListRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countList.size
    }

    override fun onBindViewHolder(holder: CountListRecyclerViewHolder, position: Int) {
        holder.countText.text = countList[position].toString()

        holder.itemView.setOnClickListener {
            listner.contentTapped(position)
        }
    }

    class CountListRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countText: TextView = itemView.findViewById(R.id.gridTextView)
    }

    fun setListner(listner: HomeAdapterListner) {
        this.listner = listner
    }

    interface HomeAdapterListner {
        fun contentTapped(position: Int)
    }
}