package com.extro.vostr.shoppinglist.notes.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.extro.vostr.shoppinglist.R
import com.extro.vostr.shoppinglist.databinding.NoteListItemBinding
import com.extro.vostr.shoppinglist.entities.NoteItem

class NoteAdapter(private val clickListener: ItemClickListener) :
    ListAdapter<NoteItem, NoteAdapter.ItemHolder>(ItemComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position))
        holder.itemView.setOnClickListener {
            clickListener.onItemListener(getItem(position))
        }
        holder.itemView.setOnLongClickListener {
            clickListener.onItemLongListener(getItem(position).id)
            true
        }
    }

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = NoteListItemBinding.bind(view)
        fun setData(note: NoteItem) = with(binding) {
            tvTitle.text = note.title
            tvDescription.text = note.content
            tvTime.text = note.time
        }

        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.note_list_item, parent, false)
                )
            }
        }
    }


    class ItemComparator : DiffUtil.ItemCallback<NoteItem>() {
        override fun areItemsTheSame(oldItem: NoteItem, newItem: NoteItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteItem, newItem: NoteItem): Boolean {
            return oldItem == newItem
        }
    }

    fun updateFile(filterItem: List<NoteItem>) {
        currentList.clear()
        currentList.addAll(filterItem)
        notifyDataSetChanged()
    }


}