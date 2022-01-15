package com.pss.highthon_android.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pss.highthon_android.R
import com.pss.highthon_android.base.BaseFragment
import com.pss.highthon_android.data.db.entity.CommentData
import com.pss.highthon_android.databinding.FragmentHomeBinding
import com.pss.highthon_android.databinding.FragmentHomeCommentBinding
import com.pss.highthon_android.view.home.adapter.HomeCommentRecyclerViewAdapter


class HomeCommentFragment :  BaseFragment<FragmentHomeCommentBinding>(R.layout.fragment_home_comment) {

    override fun init() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = HomeCommentRecyclerViewAdapter(setComment(),setNickname())
    }

    private fun setComment(): ArrayList<String> {
        return arrayListOf("생일축하포카링~","기모띠 야매떄~","이거슨 예시","킥킥스")
    }

    private fun setNickname(): ArrayList<String>{
        return arrayListOf("adfds~","기모ewfe띠~","aadsf예시","asdfa")
    }

}