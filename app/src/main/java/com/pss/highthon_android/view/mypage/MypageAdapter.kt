package com.pss.highthon_android.view.mypage

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pss.highthon_android.R
import com.pss.highthon_android.data.remote.model.MyPost
import com.pss.highthon_android.databinding.MyPostItemBinding
import android.content.res.Resources
import android.view.View
import com.pss.highthon_android.viewmodel.FAQViewModel
import java.util.*
import kotlin.collections.ArrayList


class MypageAdapter(dataNickName : ArrayList<MyPost>,fragment : MyPostFragment, viewmodel : FAQViewModel): RecyclerView.Adapter<MypageAdapter.PagerViewHolder>() {

    var dataNickName = dataNickName
    var fragment = fragment
    var viewmodel = viewmodel

    inner class PagerViewHolder(val binding: MyPostItemBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<MyPostItemBinding>(
            layoutInflater,
            R.layout.my_post_item,
            parent,
            false
        )
        return PagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
       holder.binding.titleTexeView.setText(dataNickName.get(position).title)
       holder.binding.textView11.setText(dataNickName.get(position).date)

        val random = Random()
        val num = random.nextInt(5)

        when(num)
        {
            0 -> holder.binding.imageview.imageTintList = ColorStateList.valueOf(Color.parseColor("#FA9595"))
            1 -> holder.binding.imageview.imageTintList = ColorStateList.valueOf(Color.parseColor("#9E96F3"))
            2 -> holder.binding.imageview.imageTintList = ColorStateList.valueOf(Color.parseColor("#7FEA3E"))
            3 -> holder.binding.imageview.imageTintList = ColorStateList.valueOf(Color.parseColor("#37E5B1"))
            4 -> holder.binding.imageview.imageTintList = ColorStateList.valueOf(Color.parseColor("#F3B742"))
        }

        if(dataNickName.get(position).category != viewmodel.category.value && viewmodel.category.value != "전체")
        {
            Log.d("view",viewmodel.category.value.toString())
            holder.binding.imageview.imageTintList = ColorStateList.valueOf(Color.parseColor("#e6e6e6"))
        }

    }

    override fun getItemCount(): Int {
        return dataNickName.size
    }
}