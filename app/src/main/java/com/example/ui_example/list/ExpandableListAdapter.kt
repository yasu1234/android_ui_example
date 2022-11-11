package com.example.ui_example.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.ui_example.R

class ExpandableListAdapter(
    private val context: Context,
    var dataList: Map<String, List<String>>?
 ): BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        if (!dataList.isNullOrEmpty()) {
            return dataList!!.keys.size
        }
        return 0
    }

    override fun getChildrenCount(p0: Int): Int {
        if (!dataList.isNullOrEmpty()) {
            val key = dataList!!.keys.elementAt(p0)
            val list = dataList!![key]
            if (!list.isNullOrEmpty()) {
                return list.size
            }
        }
        return 0
    }

    override fun getGroup(p0: Int): Any {
        if (!dataList.isNullOrEmpty()) {
            return dataList!!.keys.elementAt(p0)
        }
        return ""
    }

    override fun getChild(p0: Int, p1: Int): Any {
        if (!dataList.isNullOrEmpty()) {
            val key = dataList!!.keys.elementAt(p0)
            val childData = dataList!![key]
            if (!childData.isNullOrEmpty()) {
                return childData[p1]
            }
        }
        return ""
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        p0: Int,
        p1: Boolean,
        p2: View?,
        p3: ViewGroup?
    ): View {
        var title = ""
        var convertView = p2
        if (!dataList.isNullOrEmpty()) {
            title = dataList!!.keys.elementAt(p0)
        }
        if (convertView == null) {
            val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.expandable_cell, null)
        }

        val titleTextView = convertView!!.findViewById<TextView>(R.id.expandableTitleTextView)
        titleTextView.text = title

        return convertView
    }

    override fun getChildView(
        p0: Int,
        p1: Int,
        p2: Boolean,
        p3: View?,
        p4: ViewGroup?
    ): View {
        var convertView = p3

        var title = ""
        val key = dataList!!.keys.elementAt(p0)
        val childData = dataList!![key]
        if (!childData.isNullOrEmpty()) {
            title = childData[p1]
        }
        if (convertView == null) {
            val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.expandable_cell, null)
        }

        val titleTextView = convertView!!.findViewById<TextView>(R.id.expandableTitleTextView)
        titleTextView.text = title

        return convertView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }
}