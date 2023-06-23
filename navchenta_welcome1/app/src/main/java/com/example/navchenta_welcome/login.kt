package com.example.navchenta_welcome

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.navchenta_welcome.bottom.BottomNav
import com.example.navchenta_welcome.navigation.Drawer
import com.google.android.material.navigation.NavigationView
import org.w3c.dom.Text

class login : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email_text = findViewById<TextView>(R.id.login_email)
        val password_text = findViewById<TextView>(R.id.login_passward)
        val login_btn = findViewById<Button>(R.id.login_button)
        var enteredName = ""
        var go_to_signup=findViewById<TextView>(R.id.go_to_singup)
        enteredName = email_text.text.toString()

        login_btn.setOnClickListener {
            val intent = Intent(this, Drawer::class.java)
//            intent.putExtra("USER", enteredName)
            startActivity(intent)
        }

        go_to_signup.setOnClickListener {
            val intent = Intent(this, Sing_up::class.java)
//            intent.putExtra("USER", enteredName)
            startActivity(intent)
        }
        // Inside LoginActivity onCreate()
        val sharedPreferences = getSharedPreferences("navchetna_welcome1", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        val isAppInstalled = sharedPreferences.getBoolean("isAppInstalled", false)

        if (isLoggedIn && isAppInstalled) {
            // User is already logged in and the app is installed, start the home activity
            val intent = Intent(this,Drawer::class.java)
            startActivity(intent)
            finish() // Finish the LoginActivity so the user can't go back to it
        } else {
            // Clear the login status if the app was uninstalled and relaunched
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn", false)
            editor.apply()
        }


    }
}