package com.extro.vostr.shoppinglist.shopList.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.extro.vostr.shoppinglist.databinding.FragmentNewShopListBinding
import com.extro.vostr.shoppinglist.shopList.domain.ListItem
import com.extro.vostr.shoppinglist.shopList.ui.adapter.ListItemAdapter
import com.extro.vostr.shoppinglist.shopList.ui.viewmodel.NewShopListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

const val EXTRA_ID_SHOP_LIST = "id_shopList"
const val EXTRA_LIST_SHOP_LIST = "list_shopList"
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

        })
        binding.rvShopList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvShopList.adapter = adapter

        val idShopList = requireArguments().getInt(EXTRA_ID_SHOP_LIST)
        val listItem = arguments?.getParcelableArrayList<ListItem>(EXTRA_LIST_SHOP_LIST)
       // val listItem =  requireActivity().intent.getParcelableArrayListExtra(EXTRA_LIST_SHOP_LIST, ListItem::class.java)


        Log.d("idShopList", "$idShopList")

        if (listItem != null) {
            adapter.listItem.addAll(listItem)
        }

        if(idShopList == 0){
            addItem(ListItem("", false))
        }

        binding.tvAddItem.setOnClickListener {
            addItem(ListItem("", false))
        }

        binding.btAddList.setOnClickListener {
            if(idShopList == 0){
                viewModel.addShopList(binding.edTitle.text.toString(), adapter.listItem)
                findNavController().popBackStack()
            } else {

            }
        }

        binding.btBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun addItem(item : ListItem){
        adapter.addItem(item)
    }

    fun removeItem(position : Int){
        adapter.removeItem(position)
    }

    companion object {
        fun createArgs(
            id : Int?,
            list : List<ListItem>?
        ) : Bundle = bundleOf(
            EXTRA_ID_SHOP_LIST to id,
            EXTRA_LIST_SHOP_LIST to list
        )
    }

}