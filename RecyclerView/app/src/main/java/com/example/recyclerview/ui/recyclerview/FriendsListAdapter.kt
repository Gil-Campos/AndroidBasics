package com.example.recyclerview.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerview.data.model.Friend
import com.example.recyclerview.databinding.ItemFeatureBinding

class FriendsListAdapter() : ListAdapter<Friend, BaseListViewHolder<*>>(DiffUtilCallback) {

    private object DiffUtilCallback : DiffUtil.ItemCallback<Friend>() {
        override fun areItemsTheSame(oldItem: Friend, newItem: Friend): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Friend, newItem: Friend): Boolean =
            oldItem == newItem

    }

    inner class BindViewHolderList(private val binding: ItemFeatureBinding) :
        BaseListViewHolder<Friend>(binding.root) {

        override fun bind(item: Friend, position: Int) = with(binding) {
            textViewItem.text = item.name
            constraintLayoutBaseFeature.setOnClickListener {
                onFriendClickListener?.let { click ->
                    click(item)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder<*> {
        val itemBinding =
            ItemFeatureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BindViewHolderList(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseListViewHolder<*>, position: Int) {
        when (holder) {
            is BindViewHolderList -> holder.bind(getItem(position), position)
        }
    }

    private var onFriendClickListener: ((Friend) -> Unit)? = null

    fun setFriendClickListeners(listener: (Friend) -> Unit) {
        onFriendClickListener = listener
    }

}