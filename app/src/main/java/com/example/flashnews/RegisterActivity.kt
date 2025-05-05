package com.example.flashnews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Menambahkan referensi ImageView
        val imgLogo: ImageView = findViewById(R.id.imgLogo)
        imgLogo.setImageResource(R.drawable.logo)  // Mengatur gambar logo di ImageView

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val usernameField = findViewById<EditText>(R.id.etRegUsername)
        val emailField = findViewById<EditText>(R.id.etRegEmail)
        val passwordField = findViewById<EditText>(R.id.etRegPassword)

        btnRegister.setOnClickListener {
            val username = usernameField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            // Cek apakah semua field sudah diisi
            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                // Simpan data ke SharedPreferences
                val sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("username", username)
                editor.putString("email", email)
                editor.putString("password", password)
                editor.apply()

                // Berpindah ke halaman Login setelah registrasi
                Toast.makeText(this, "Registrasi berhasil! Silakan login.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
