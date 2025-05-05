package com.example.flashnews

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewsDashboardActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_dashboard)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemList = listOf(
            ItemList(
                judul = "Indonesia Merdeka",
                subJudul = "Indonesia Merdeka Tahun 1945",
                imageUrl = "https://storage.googleapis.com/finansialku_media/wordpress_media/2019/08/afba1579-jangan-ngaku-wni-jika-belum-tahu-sejarah-singkat-kemerdekaan-indonesia-01-finansialku.jpg"
            ),
            ItemList(
                judul = "UTB",
                subJudul = "Universitas Teknologi Bandung",
                imageUrl = "https://destinasibandung.co.id/wp-content/uploads/2024/03/IMG-20240306-WA0001.jpg"
            ),
            ItemList(
                judul = "Lebaran 2023",
                subJudul = "1 Syawal tahun ini jatuh pada tanggal 22 April 2023",
                imageUrl = "https://maluku.kemenag.go.id/upload/artikel/medium_20-04-2023-08-44-32-3296.jpg"
            )
        )

        adapter = AdapterList(itemList)
        recyclerView.adapter = adapter
    }

    override fun onBackPressed() {
        // Menambahkan log untuk debugging
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()  // Pastikan Activity sebelumnya tertutup
    }
}
