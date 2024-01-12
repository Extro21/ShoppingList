package com.extro.vostr.shoppinglist.shopList.ui.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.extro.vostr.shoppinglist.R
import com.extro.vostr.shoppinglist.databinding.FragmentShoplistBinding
import com.extro.vostr.shoppinglist.shopList.domain.ListItem
import com.extro.vostr.shoppinglist.shopList.ui.adapter.ListItemAdapter
import com.extro.vostr.shoppinglist.shopList.ui.adapter.ListItemAdapterPrew
import com.extro.vostr.shoppinglist.shopList.ui.adapter.ShopListAdapter
import com.extro.vostr.shoppinglist.shopList.ui.viewmodel.ShopListViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ShoplistFragment : Fragment() {

    private lateinit var binding : FragmentShoplistBinding

    private var adapterItems = ListItemAdapter()
    private var adapterItemsPrew = ListItemAdapterPrew()
    private var mCollectRecyclerView: RecyclerView? = null

    private val viewModel : ShopListViewModel by viewModel()

     private val listItemPrew = ArrayList<ListItem> ()

    private val adapter = ShopListAdapter(listItemPrew) { shopItem ->
        lifecycleScope.launch {
            viewModel.getItemForShopList(shopItem.idShoplist).collect{ shopList ->
                Log.d("checkReally", "$shopList")
               // val list = convectorShopItemToItem(shopList)
                listItemPrew.clear()
                listItemPrew.addAll(shopList)
                findNavController().navigate(
                    R.id.action_shoplistFragment_to_newShopListFragment,
                    NewShopListFragment.createArgs(
                        shopItem.idShoplist, shopList
                    )
                )
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoplistBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initRecyclerView() {
        mCollectRecyclerView = view?.findViewById(R.id.rvShopListPreView)
        mCollectRecyclerView?.adapter = adapterItemsPrew
        mCollectRecyclerView?.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapterItemsPrew.listItem.addAll(arrayListOf(ListItem("ss", true)))
       // adapterItems.notifyDataSetChanged()

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
            findNavController().navigate(
                R.id.action_shoplistFragment_to_newShopListFragment,
                NewShopListFragment.createArgs(
                    null, null
                )
            )
        }

        initRecyclerView()
    }

//    private fun mup(shoppingListItem: ShoppingListItem) : ListItem {
//        val isChecked : Boolean = shoppingListItem.itemChecked != 0
//        return ListItem(
//            text =  shoppingListItem.content,
//            isChecked = isChecked
//        )
//    }
//    private fun convectorShopItemToItem(shopList : List<ShoppingListItem>) : List<ListItem>{
//        return shopList.map { item -> mup(item) }
//    }

}