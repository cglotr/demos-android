package com.example.cglotr.listv.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.cglotr.listv.R
import kotlinx.android.synthetic.main.row_view.view.*

class ListViewAdapter: BaseAdapter() {

    private val mNames = arrayListOf(
        "1","1"
    )

    init {
        for (i in 0..10) {
            val len = mNames.size
            val a = mNames[len - 2].toInt()
            val b = mNames[len - 1].toInt()
            mNames.add((a + b).toString())
        }
    }

    override fun getCount(): Int {
        return mNames.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var rowView = convertView

        if (rowView == null) {
            val layoutInflater = LayoutInflater.from(parent!!.context)
            rowView = layoutInflater.inflate(R.layout.row_view, parent, false)!!

            rowView.tag = ViewHolder(rowView.textView_name, rowView.textView_number)
        }

        val viewHolder = (rowView.tag as ViewHolder)
        viewHolder.nameView.text = "Fibonacci: ${mNames[position]}"
        viewHolder.numberView.text = "Row number: $position"

        return rowView
    }

    private class ViewHolder(val nameView: TextView, val numberView: TextView)
}
