package com.pss.highthon_android.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pss.highthon_android.R
import com.pss.highthon_android.databinding.CategoryItemBinding

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryRecyclerViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CategoryItemBinding>(
            layoutInflater,
            R.layout.category_item,
            parent,
            false
        )
        return CategoryRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryRecyclerViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 5

    inner class CategoryRecyclerViewHolder(val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        /*fun bind(data: Question) {
            binding.data = data
            binding.executePendingBindings()
        }*/
    }
}