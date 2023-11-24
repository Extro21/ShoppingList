package com.extro.vostr.shoppinglist.root

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.extro.vostr.shoppinglist.R
import com.extro.vostr.shoppinglist.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container_view) as NavHostFragment
        val  navController = navHostFragment.navController

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bNav)
        bottomNavView.setupWithNavController(navController)

       // setBottomNavListener()

    }

//    private fun setBottomNavListener(){
//        binding.bNav.setOnItemSelectedListener {
//            when(it.itemId){
//                R.id.bNav -> {}
//                R.id.notes -> {
//                    FragmentManager.setFragment(NoteFragment.newInstance(), this)
//                }
//                R.id.new_item ->{}
//                R.id.title -> {}
//            }
//            true
//        }
//    }

}