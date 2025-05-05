package com.example.flashnews

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterList
    private lateinit var itemList: List<ItemList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        itemList = listOf(
            ItemList("Berita 1", "Subjudul 1", "https://via.placeholder.com/600x300"),
            ItemList("Berita 2", "Subjudul 2", "https://via.placeholder.com/600x300"),
            ItemList("Berita 3", "Subjudul 3", "https://via.placeholder.com/600x300")
        )

        adapter = AdapterList(itemList)
        recyclerView.adapter = adapter
    }
}
