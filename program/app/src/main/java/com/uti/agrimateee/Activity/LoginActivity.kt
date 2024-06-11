package com.uti.agrimateee.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uti.agrimate.Class.db
import com.uti.agrimateee.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    //    deklarasi binding untuk databaseHelper
    private lateinit var databaseHelper: db

    //    deklarasi sharePref
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        buat variabel binding untuk LoginActivity
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding databaseHelper
        databaseHelper = db(this)

        sharedPref = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

//        event btnLogin
        binding.btnLogin.setOnClickListener {
            val username = binding.Username.text.toString()
            val password = binding.Password.text.toString()
            loginDatabase(username, password)
        }

//        event txRegis
        binding.txRegis.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //    membaca username dan password dari SQLite
    private fun loginDatabase(username: String, password: String) {
//        periksa apakah username dan password sudah diisi
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username atau Password tidak boleh kosong !", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val userExists = databaseHelper.readUser(username, password)
        if (userExists) {
            // Simpan username ke SharedPreferences
            with(sharedPref.edit()) {
                putString("logged_in_user", username)
                apply()
            }

//            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Username atau Password tidak sesuai !", Toast.LENGTH_SHORT).show()
        }
    }
}