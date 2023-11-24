package com.extro.vostr.shoppinglist.shopList.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.extro.vostr.shoppinglist.databinding.FragmentShoplistBinding

class ShoplistFragment : Fragment() {

    private lateinit var binding : FragmentShoplistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoplistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.newShoplist.setOnClickListener {
            Log.d("logNewNote", "???????")
        }
    }

}