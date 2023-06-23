package com.example.navchenta_welcome

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.Toast
class Sing_up : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)
        val update_btn = findViewById<Button>(R.id.signup)
            var go_to_login =findViewById<TextView>(R.id.go_to_login)





        update_btn.setOnClickListener {
                val intent = Intent(this, login::class.java)
//            intent.putExtra("USER", enteredName)
                startActivity(intent)
            }

            go_to_login.setOnClickListener {
                val intent = Intent(this, login::class.java)
//            intent.putExtra("USER", enteredName)
                startActivity(intent)

            }
        val sharedPreferences = getSharedPreferences("navchetna_welcome", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", true)
        editor.putBoolean("isAppInstalled", true) // Store the flag indicating app installation
        editor.apply()
    }
}