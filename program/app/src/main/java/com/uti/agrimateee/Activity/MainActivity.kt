package com.uti.agrimateee.Activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uti.agrimate.Class.db
import com.uti.agrimateee.R
import com.uti.agrimateee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //    deklarasi binding databaseHelper dan sharedPref
    private lateinit var databaseHelper: db
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Buat variabel binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Binding database
        databaseHelper = db(this)
        sharedPref = getSharedPreferences("user_prefs", MODE_PRIVATE)

        // Buat event menu
        binding.cdMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        // Buat event profil
        binding.cdTentang.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }


        // Ambil nama pengguna dari SharedPreferences dan tampilkan
        val username = getLoggedInUsername()
        binding.textUsername.text = username

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getLoggedInUsername(): String {
        // Ambil username dari SharedPreferences
        return sharedPref.getString("logged_in_user", "Guest") ?: "Guest"
    }
}