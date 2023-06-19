package com.example.navchenta_welcome


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var Navcontroller : NavController = findNavController(R.id.fragmentContainerView)
        var bottomNav : BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNav.setupWithNavController(Navcontroller)
    }
}