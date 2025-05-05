package com.example.flashnews

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton: Button = findViewById(R.id.btnLogin)
        val usernameField: EditText = findViewById(R.id.etUsername) // ID yang benar
        val passwordField: EditText = findViewById(R.id.etPassword) // ID yang benar

        loginButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            // Pastikan username dan password sudah diinput
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Cek username dan password dari SharedPreferences
                val sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
                val storedUsername = sharedPreferences.getString("username", null)
                val storedPassword = sharedPreferences.getString("password", null)

                if (username == storedUsername && password == storedPassword) {
                    // Jika login berhasil
                    startActivity(Intent(this, NewsDashboardActivity::class.java))
                    finish()
                } else {
                    // Menampilkan error jika login gagal
                    Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Menampilkan error jika username atau password kosong
                Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Fungsi ini akan dipanggil dari XML via android:onClick="onRegisterClick"
    fun onRegisterClick(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}
