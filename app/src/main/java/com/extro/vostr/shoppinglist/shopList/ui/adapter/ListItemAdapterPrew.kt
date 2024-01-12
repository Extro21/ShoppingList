package com.extro.vostr.shoppinglist.shopList.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.extro.vostr.shoppinglist.R
import com.extro.vostr.shoppinglist.shopList.domain.ListItem

class ListItemAdapterPrew : RecyclerView.Adapter<ListItemAdapterPrew.ViewHolder>() {

    var listItem = ArrayList<ListItem>()
   // var listItem = ArrayList<ShopListItemsPrew>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        val content : TextView = itemView.findViewById(R.id.edContent)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.check_boc_item_prew, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItem[position]
        holder.content.text = item.text
        holder.checkBox.isChecked = item.isChecked
        holder.checkBox.isClickable = false
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            item.isChecked = isChecked
        }
        holder.content.addTextChangedListener {
            item.text = it.toString()
        }
    }

    fun getListAdapter() : MutableList<ListItem>{
        return listItem
    }

    fun addItem(item: ListItem) {
        listItem.add(item)
        notifyItemInserted(listItem.size - 1)
    }

    fun removeItem(position: Int) {
        listItem.removeAt(position)
        notifyItemRemoved(position)
    }

}