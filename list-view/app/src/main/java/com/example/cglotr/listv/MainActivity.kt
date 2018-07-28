package com.example.cglotr.listv

import android.app.Activity
import android.os.Bundle
import android.widget.ListView
import com.example.cglotr.listv.ui.ListViewAdapter

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listView)
        listView.adapter = ListViewAdapter(this)
    }
}
