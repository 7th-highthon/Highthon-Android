package com.pss.highthon_android.view.home.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.pss.highthon_android.R
import com.pss.highthon_android.data.db.entity.CommentData

class HomeCommentRecyclerViewAdapter(dataNickName : ArrayList<String>, dataComment : ArrayList<String>): RecyclerView.Adapter<HomeCommentRecyclerViewAdapter.PagerViewHolder>() {

    var dataNickName = dataNickName

    var dataComment = dataComment

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.home_comment_item, parent, false))
    {
            val nickname = itemView.findViewById<TextView>(R.id.nickname_textview)
            val comment = itemView.findViewById<TextView>(R.id.comment_textView)
            val background = itemView.findViewById<ConstraintLayout>(R.id.comment_contentview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder((parent))
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.nickname.setText(dataNickName?.get(position))
        holder.comment.setText(dataComment?.get(position))
    }

    override fun getItemCount(): Int {
        Log.d("thisthis", dataNickName.size.toString())
        return dataNickName.size
    }
}