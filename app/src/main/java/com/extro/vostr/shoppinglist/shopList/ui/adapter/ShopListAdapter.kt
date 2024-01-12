package com.extro.vostr.shoppinglist.shopList.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.extro.vostr.shoppinglist.R
import com.extro.vostr.shoppinglist.databinding.ShopListItemBinding
import com.extro.vostr.shoppinglist.entities.ShoppingListNames
import com.extro.vostr.shoppinglist.shopList.domain.ListItem

class ShopListAdapter(private val listItem : ArrayList<ListItem>,private val clickListenerItem: ShopItemClickListener) :
    ListAdapter<ShoppingListNames, ShopListAdapter.ItemHolder>(ItemComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))

        val innerAdapter = ListItemAdapterPrew ()

        innerAdapter.listItem.addAll(listItem)
        holder.rvView.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.rvView.adapter = innerAdapter

        holder.itemView.setOnClickListener {
            clickListenerItem.itemClickListener(getItem(position))
        }
        holder.rvView.setOnClickListener {
            clickListenerItem.itemClickListener(getItem(position))
        }
    }


    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ShopListItemBinding.bind(view)
        val rvView : RecyclerView = view.findViewById(R.id.rvShopListPreView)

        fun bind(shopList: ShoppingListNames) = with(binding) {
            tvTitle.text = shopList.name
        }

        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.shop_list_item, parent, false)
                )
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<ShoppingListNames>() {
        override fun areItemsTheSame(
            oldItem: ShoppingListNames,
            newItem: ShoppingListNames
        ): Boolean {
            return oldItem.idShoplist == newItem.idShoplist
        }

        override fun areContentsTheSame(
            oldItem: ShoppingListNames,
            newItem: ShoppingListNames
        ): Boolean {
            return oldItem == newItem
        }
    }


}