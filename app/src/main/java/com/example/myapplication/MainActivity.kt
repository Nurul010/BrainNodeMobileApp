package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val firstFragment = FirstFragment()
        val settingsFragment = SettingsFragment()
        val navView : BottomNavigationView = findViewById(R.id.bottomNavigationView)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Frame_Layout, firstFragment)
            commit()
        }

        navView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Home -> replaceFragment(homeFragment)
                R.id.Settings -> replaceFragment(settingsFragment)
            }
            true
        }
    }


    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.Frame_Layout, fragment)
        fragmentTransaction.commit()
    }



}