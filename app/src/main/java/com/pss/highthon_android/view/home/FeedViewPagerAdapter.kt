package com.pss.highthon_android.view.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pss.highthon_android.R
import com.pss.highthon_android.data.remote.model.Post
import com.pss.highthon_android.databinding.FeedItemBinding
import com.pss.highthon_android.viewmodel.HomeViewModel

class FeedViewPagerAdapter(
    private val viewModel: HomeViewModel,
    private val imgList: ArrayList<Int>
) : RecyclerView.Adapter<FeedViewPagerAdapter.FeedViewPagerViewHolder>() {


    override fun getItemCount(): Int {
        return viewModel.postList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewPagerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FeedItemBinding>(
            layoutInflater,
            R.layout.feed_item,
            parent,
            false
        )
        return FeedViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewPagerViewHolder, position: Int) {
        holder.binding.imageView.clipToOutline = true
        holder.binding.imageView.apply {
            when (viewModel.eventChoiceCategory.value) {
                "birthday" -> {
                    setImageResource(imgList[0])
                }
                "graduated" -> {
                    setImageResource(imgList[1])
                }
                "employment" -> {
                    setImageResource(imgList[2])
                }
                "romantic" -> {
                    setImageResource(imgList[3])
                }
                "etc" -> {
                    setImageResource(imgList[4])
                }
            }
        }
        holder.binding.imageView.setOnClickListener {
            viewModel.callEventFeedClick(position)
        }

        holder.bind(viewModel.postList[position])
    }

    inner class FeedViewPagerViewHolder(val binding: FeedItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Post) {
            binding.data = data
            binding.executePendingBindings()
        }
    }
}