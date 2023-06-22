package com.example.navchenta_welcome

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

        update_btn.setOnClickListener {
            val intent = Intent(this, login::class.java)
//            intent.putExtra("USER", enteredName)
            startActivity(intent)
        }
    }
}