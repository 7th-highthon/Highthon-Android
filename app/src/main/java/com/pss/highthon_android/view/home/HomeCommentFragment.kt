package com.pss.highthon_android.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pss.highthon_android.R
import com.pss.highthon_android.base.BaseFragment
import com.pss.highthon_android.data.db.entity.CommentData
import com.pss.highthon_android.databinding.FragmentHomeBinding
import com.pss.highthon_android.databinding.FragmentHomeCommentBinding
import com.pss.highthon_android.view.home.adapter.HomeCommentRecyclerViewAdapter
import com.pss.highthon_android.viewmodel.HomeViewModel
import com.pss.highthon_android.viewmodel.MainViewModel


class HomeCommentFragment :
    BaseFragment<FragmentHomeCommentBinding>(R.layout.fragment_home_comment) {
    private val homeViewModel by activityViewModels<HomeViewModel>()
    private val mainViewModel by activityViewModels<MainViewModel>()


    override fun init() {
        binding.fragment = this
        with(homeViewModel.postList[homeViewModel.eventFeedClick.value!!]) {
            binding.title.text = this.title
            binding.content.text = this.content
        }
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = HomeCommentRecyclerViewAdapter(setComment(), setNickname())
    }

    fun clickBackBtn(view: View) {
        mainViewModel.setActionView(true)
        this.findNavController().popBackStack()
    }

    private fun setComment(): ArrayList<String> {
        return if (homeViewModel.eventFeedClick.value == 0) arrayListOf(
            "박상선",
            "정민혁",
            "김민주",
            "최윤성"
        )
        else if (homeViewModel.eventFeedClick.value == 1) arrayListOf(
            "민경모",
            "강산하",
            "양태웅",
            "정직한"
        )
        else arrayListOf(
            "민경모",
            "강산하",
            "양태웅",
            "정직한"
        )
    }

    private fun setNickname(): ArrayList<String> {
        return if (homeViewModel.eventFeedClick.value == 0) arrayListOf(
            "생일축하포카링~ 짜식 맛있는거 많이 먹으라",
            "간단히 쓴다, 추카",
            "이열~ 생일 축하하고 학교에서 보자~",
            "선배 생일 축하해요, 앞으로도 잘 부탁드려요!"
        )
        else if (homeViewModel.eventFeedClick.value == 1) arrayListOf(
            "생일 축하는 하는데 말이야.. 그래.. 축하하다..~",
            "생일빵 받으러 간다, 잠깐 딱 기다리도록",
            "너 이 자식!!!!!!! 생축",
            "나도 내일 생일이다, 물론 구라고~"
        )
        else arrayListOf(
            "생일 축하는 하는데 말이야.. 그래.. 축하하다..~",
            "생일빵 받으러 간다, 잠깐 딱 기다리도록",
            "이거슨 예시",
            "킥킥스"
        )
    }

}