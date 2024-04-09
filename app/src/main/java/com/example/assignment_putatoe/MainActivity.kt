package com.example.assignment_putatoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_nav)
        bottomNav.selectedItemId = R.id.home
        inflateFragment(HomeFragment.newInstance())

        bottomNav.setOnItemSelectedListener { menuItem ->
            val fragment = when (menuItem.itemId) {
                R.id.home -> HomeFragment.newInstance()
                R.id.profile -> ProfileFragment.newInstance()
                R.id.list -> ListFragment.newInstance()
                R.id.chat -> ChatFragment.newInstance()
                else -> null
            }
            fragment?.let { inflateFragment(it) }
            true
        }
    }

    private fun inflateFragment(newInstance: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.containerr,newInstance)
        transaction.commit()
    }
}