package com.pss.highthon_android.view.home

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pss.highthon_android.R
import com.pss.highthon_android.databinding.CategoryItemBinding
import com.pss.highthon_android.viewmodel.HomeViewModel

class CategoryAdapter(
    private val viewModel: HomeViewModel
) : RecyclerView.Adapter<CategoryAdapter.CategoryRecyclerViewHolder>() {


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
        Log.d("로그","카테고리 ${viewModel.eventChoiceCategory.value}")

        when (viewModel.eventChoiceCategory.value) {
            //생일
            "birthday" -> {
                if (position == 0) {
                    holder.binding.frame.setBackgroundResource(R.drawable.category_choice_frame)
                    holder.binding.categoryTxt.setTextColor(Color.WHITE)
                }
            }

            //졸업
            "graduated" -> {
                if (position == 1) {
                    holder.binding.frame.setBackgroundResource(R.drawable.category_choice_frame)
                    holder.binding.categoryTxt.setTextColor(Color.WHITE)
                }
            }

            //취업
            "employment" -> {
                if (position == 2) {
                    holder.binding.frame.setBackgroundResource(R.drawable.category_choice_frame)
                    holder.binding.categoryTxt.setTextColor(Color.WHITE)
                }
            }

            //연애
            "romantic" -> {
                if (position == 3) {
                    holder.binding.frame.setBackgroundResource(R.drawable.category_choice_frame)
                    holder.binding.categoryTxt.setTextColor(Color.WHITE)
                }
            }

            //기타
            "etc" -> {
                if (position == 4) {
                    holder.binding.frame.setBackgroundResource(R.drawable.category_choice_frame)
                    holder.binding.categoryTxt.setTextColor(Color.WHITE)
                }
            }
        }
        holder.binding.frame.setOnClickListener {
            when(position){
                0 -> viewModel.setCategory("birthday")
                1 -> viewModel.setCategory("graduated")
                2 -> viewModel.setCategory("employment")
                3 -> viewModel.setCategory("romantic")
                4 -> viewModel.setCategory("etc")
            }
        }
        with(holder.binding.categoryTxt) {
            when (position) {
                0 -> this.text = "생   일"
                1 -> this.text = "졸   업"
                2 -> this.text = "취   업"
                3 -> this.text = "연   애"
                4 -> this.text = "기   타"
            }
        }
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