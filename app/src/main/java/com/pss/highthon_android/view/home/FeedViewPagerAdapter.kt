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
    private val viewModel : HomeViewModel
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
/*         holder.binding.rankingImg.apply {
            setImageResource(imgList[position])
            setColorFilter(Color.parseColor("#FFFFFF"))
        }*/

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