package com.example.infinitebanner.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.infinitebanner.databinding.ItemUserBinding

class UserListAdapter :
    ListAdapter<UserData, UserListAdapter.UserListViewHolder>(DiffUtilCallBack) {

    private object DiffUtilCallBack : DiffUtil.ItemCallback<UserData>() {
        override fun areItemsTheSame(oldItem: UserData, newItem: UserData): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: UserData, newItem: UserData): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }
    }

    inner class UserListViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: UserData) {
            binding.userText.text = data.name
            binding.phoneText.text = data.phone
        }

    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserListViewHolder {
        return UserListViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val positionFixed = position % currentList.size
        holder.bind(getItem(positionFixed))
    }
}