package com.extro.vostr.shoppinglist.shopList.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.extro.vostr.shoppinglist.databinding.FragmentNewShopListBinding
import com.extro.vostr.shoppinglist.shopList.domain.ListItem
import com.extro.vostr.shoppinglist.shopList.ui.adapter.ListItemAdapter
import com.extro.vostr.shoppinglist.shopList.ui.viewmodel.NewShopListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewShopListFragment : Fragment() {

    private lateinit var binding : FragmentNewShopListBinding
    private lateinit var adapter : ListItemAdapter

    private val viewModel : NewShopListViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewShopListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ListItemAdapter( onItemCheckedListener = { item ->
            if(item.isChecked){

            }
            if(!item.text.isNullOrEmpty()){

            }


        })
        binding.rvShopList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvShopList.adapter = adapter

        binding.addItem.setOnClickListener {
            addItem(ListItem("", false))
        }

        binding.btAddList.setOnClickListener {
            viewModel.addShopList(binding.edTitle.text.toString(), adapter.getListAdapter())
            Log.d("checkList", "${adapter.listItem}")
            findNavController().popBackStack()
        }

    }

    private fun addItem(item : ListItem){
        adapter.addItem(item)
    }

    fun removeItem(position : Int){
        adapter.removeItem(position)
    }

}