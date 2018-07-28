package com.example.cglotr.listv.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.cglotr.listv.R

class ListViewAdapter(context: Context): BaseAdapter() {

    private val mContext: Context = context
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
        val layoutInflater = LayoutInflater.from(mContext)
        val rowView = layoutInflater.inflate(R.layout.row_view, parent, false)

        val nameView = rowView.findViewById<TextView>(R.id.textView_name)
        nameView.text = "Fibonacci: ${mNames[position]}"

        val numberView = rowView.findViewById<TextView>(R.id.textView_number)
        numberView.text = "Row number: $position"

        return rowView
    }
}
