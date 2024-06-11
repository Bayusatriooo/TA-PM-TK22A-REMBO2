package com.uti.agrimateee.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var contentList: List<Pair<String, String>> // Pair of title and URL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize content list with titles and URLs
        contentList = listOf(
            "Akar wangi" to "https://id.wikipedia.org/wiki/Akar_wangi",
            "6 Manfaat Brotowali untuk Kesehatan Tubuh" to "https://www.halodoc.com/artikel/6-manfaat-brotowali-untuk-kesehatan-tubuh",
            "TANAMAN DAUN DEWA SEBAGAI OBAT HERBAL" to "https://dlh.bulelengkab.go.id/informasi/detail/artikel/34_tanaman-daun-dewa-sebagai-obat-herbal",
            "10 Manfaat Jahe untuk Kesehatan yang Wajib Diketahui" to "https://www.siloamhospitals.com/informasi-siloam/artikel/manfaat-jahe-untuk-kesehatan",
            "KHASIAT DAUN KAYU PUTIH, PROSES DAN PENGOLAHANNYA" to "https://kebudayaan.kemdikbud.go.id/bpnbmaluku/khasiat-daun-kayu-putih-proses-dan-pengolahannya/",
            "4 Manfaat Daun Kemangi, Tak Hanya Nikmat untuk Lalapan" to "https://www.halodoc.com/artikel/4-manfaat-daun-kemangi-tak-hanya-nikmat-untuk-lalapan",
            "12 Manfaat Kencur bagi Kesehatan Tubuh" to "https://www.alodokter.com/khasiat-kencur-bisa-menyaingi-efek-obat-obatan-modern",
            "Kunyit adalah Tanaman Herbal, Ketahui Manfaatnya untuk Kesehatan" to "https://www.merdeka.com/jateng/kunyit-adalah-tanaman-herbal-ketahui-manfaatnya-untuk-kesehatan-kln.html",
            "BUDIDAYA LIDAH BUAYA SEBAGAI SALAH SATU TOGA (TANAMAN OBAT KELUARGA) DI PEKARANGAN" to "https://pertanian.kulonprogokab.go.id/detil/1168/budidaya-lidah-buaya-sebagai-salah-satu-toga-tanaman-obat-keluarga-di-pekarangan",
            "7 Manfaat Bunga Melati yang Jarang Diketahui" to "https://www.brilio.net/wow/cara-menanam-tanaman-hidroponik-di-atas-kolam-lele-2101271.htmlhttps://hellosehat.com/herbal-alternatif/herbal/manfaat-bunga-melati/",
            "9 Manfaat Daun Sirih untuk Kesehatan yang Sayang Dilewatkan" to "https://www.siloamhospitals.com/informasi-siloam/artikel/manfaat-daun-sirih",
            "5 Manfaat Tanaman Kemuning untuk Mengatasi Masalah Kesehatan, dari Bisul hingga Sakit Gigi" to "https://www.kompas.tv/lifestyle/474309/catat-5-manfaat-tanaman-kemuning-untuk-mengatasi-masalah-kesehatan-dari-bisul-hingga-sakit-gigi",
            "Ketahui Manfaat Bawang Dayak yang Kaya Antioksidan" to "https://www.halodoc.com/artikel/ketahui-manfaat-bawang-dayak-yang-kaya-antioksidan",
            "Pandan" to "https://id.wikipedia.org/wiki/Pandan",
            "Ini 10 Manfaat Mengkudu bagi Kesehatan Tubuh" to "https://www.halodoc.com/artikel/ini-10-manfaat-mengkudu-bagi-kesehatan-tubuh"
        )

        // Set adapter
        val adapter = Content(contentList) { title, url ->
            val intent = Intent(this, WebViewActivity::class.java).apply {
                putExtra("title", title)
                putExtra("url", url)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter

    }
}