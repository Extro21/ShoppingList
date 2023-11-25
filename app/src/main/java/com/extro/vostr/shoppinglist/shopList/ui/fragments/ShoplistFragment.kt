package com.extro.vostr.shoppinglist.shopList.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.extro.vostr.shoppinglist.R
import com.extro.vostr.shoppinglist.databinding.FragmentShoplistBinding
import com.extro.vostr.shoppinglist.shopList.ui.adapter.ListItemAdapter
import com.extro.vostr.shoppinglist.shopList.ui.adapter.ShopListAdapter
import com.extro.vostr.shoppinglist.shopList.ui.viewmodel.ShopListViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShoplistFragment : Fragment() {

    private lateinit var binding : FragmentShoplistBinding

    private val adapter = ShopListAdapter()
    private val adapterItems = ListItemAdapter()


    private val viewModel : ShopListViewModel by viewModel()

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

        binding.apply {
            rvShopList.layoutManager = GridLayoutManager(requireContext(), 2)
            rvShopList.adapter = adapter
        }

        lifecycleScope.launch {
            viewModel.getShopList().collect(){
                adapter.submitList(it)
            }
        }


        binding.newShoplist.setOnClickListener {
            findNavController().navigate(R.id.action_shoplistFragment_to_newShopListFragment)
        }
    }

}