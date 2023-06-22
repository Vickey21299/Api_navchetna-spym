package com.example.navchenta_welcome

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

//
//        val drawerLayout: DrawerLayout =findViewById(R.id.drawerLayout)
//        val navView: NavigationView = findViewById(R.id.nav_view)

//        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        navView.setNavigationItemSelectedListener {
//
//            when(it.itemId){
//
//                R.id.nav_home -> Toast.makeText(applicationContext,"Clicked Home",Toast.LENGTH_SHORT).show()
//                R.id.nav_message -> Toast.makeText(applicationContext,"Clicked Message",Toast.LENGTH_SHORT).show()
//                R.id.nav_sync -> Toast.makeText(applicationContext,"Clicked Sync",Toast.LENGTH_SHORT).show()
//                R.id.nav_trash -> Toast.makeText(applicationContext,"Clicked Delete",Toast.LENGTH_SHORT).show()
//                R.id.nav_setting -> Toast.makeText(applicationContext,"Clicked Setting",Toast.LENGTH_SHORT).show()
//                R.id.nav_Login -> Toast.makeText(applicationContext,"Clicked Login",Toast.LENGTH_SHORT).show()
//                R.id.nav_share -> Toast.makeText(applicationContext,"Clicked Share",Toast.LENGTH_SHORT).show()
//                R.id.nav_rate_us -> Toast.makeText(applicationContext,"Clicked Rate us",Toast.LENGTH_SHORT).show()
//
//            }
//            true
//        }

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

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}