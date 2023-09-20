package com.extro.vostr.shoppinglist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.extro.vostr.shoppinglist.R
import com.extro.vostr.shoppinglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNavListener()

    }

    private fun setBottomNavListener(){
        binding.bNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bNav -> {}
                R.id.notes -> {}
                R.id.new_item ->{}
                R.id.title -> {}
            }
            true
        }
    }

}