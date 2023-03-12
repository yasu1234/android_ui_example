package com.example.ui_example.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_example.R

enum class ItemType(val status: String) {
    Hoge("HOGE"),
    Fuga("FUGA"),
    Piyo("PIYO")
}

class DifferentTypeRecyclerAdapter(
    context: Context,
    val itemList: MutableList<ItemType>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    enum class ViewType(val id: Int) {
        Hoge(0) {
            override fun createViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup?): RecyclerView.ViewHolder {
                return HogeViewHolder(inflater.inflate(R.layout.adapter_hoge, viewGroup, false))
            }

            override fun bindViewHolder(
                holder: RecyclerView.ViewHolder,
                itemType: ItemType,
                listener: OnItemListener
            ) {
                holder as HogeViewHolder

                holder.titleText.text = itemType.status
            }
        },
        Fuga(1) {
            override fun createViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup?): RecyclerView.ViewHolder {
                return FugaViewHolder(inflater.inflate(R.layout.adapter_fuga, viewGroup, false))
            }

            override fun bindViewHolder(
                holder: RecyclerView.ViewHolder,
                itemType: ItemType,
                listener: OnItemListener
            ) {
                holder as FugaViewHolder

                holder.titleText.text = itemType.status
            }
        },
        Piyo(2) {
            override fun createViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup?): RecyclerView.ViewHolder {
                return PiyoViewHolder (inflater.inflate(R.layout.adapter_piyo, viewGroup, false))
            }

            override fun bindViewHolder(
                holder: RecyclerView.ViewHolder,
                itemType: ItemType,
                listener: OnItemListener
            ) {
                holder as PiyoViewHolder

                holder.titleText.text = itemType.status

                holder.nextButton.setOnClickListener {
                    listener.onNextButtonPushed()
                }
            }
        };

        companion object {
            fun forId(id: Int): ViewType {
                for (viewType: ViewType in values()) {
                    if (viewType.id == id) {
                        return viewType
                    }
                }
                throw AssertionError("no enum found for the id. you forgot to implement?")
            }
        }

        abstract fun createViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup?): RecyclerView.ViewHolder
        abstract fun bindViewHolder(holder: RecyclerView.ViewHolder, itemType: ItemType, listener: OnItemListener)
    }

    private val inflater = LayoutInflater.from(context)
    lateinit var listener: OnItemListener

    override fun getItemCount(): Int {
        return itemList.size
    }

    // Viewを作る時に呼ばれる
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewType.forId(viewType).createViewHolder(inflater, parent)
    }

    // ViewにデータをBindする時に呼ばれる
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList[position]
        ViewType.forId(holder.itemViewType).bindViewHolder(holder, item, listener)
    }

    // You can use different layouts by overriding getItemViewType in the Adapter and returning the ViewType according to the data.
    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            ItemType.Hoge -> {
                ViewType.Hoge.id
            }
            ItemType.Fuga -> {
                ViewType.Fuga.id
            }
            ItemType.Piyo -> {
                ViewType.Piyo.id
            }
            else -> {
                throw AssertionError("no enum found for the id. you forgot to implement?")
            }
        }
    }

    interface OnItemListener {
        fun onNextButtonPushed()
    }

    fun setOnItemListener(listener: OnItemListener) {
        this.listener = listener
    }

    companion object {
        private class HogeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val titleText: TextView = itemView.findViewById(R.id.hogeTitleTextView)
        }

        private class FugaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val titleText: TextView = itemView.findViewById(R.id.fugaTitleTextView)
        }

        private class PiyoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val titleText: TextView = itemView.findViewById(R.id.piyoTitleTextView)
            val nextButton: Button = itemView.findViewById(R.id.piyoNextButton)
        }
    }
}