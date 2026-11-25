package com.hibba.laxora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomnav)

        // 1) Pehle listener set karein
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeicon -> {
                    showFragment(HomeFragment())
                    true
                }
                R.id.exploreicon -> {
                    showFragment(ExploreFragment())
                    true
                }
                R.id.profileicon -> {
                    showFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }

        // 2) Phir default item select karein (sirf pehli baar)
        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.homeicon
        }
    }

    private fun showFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}