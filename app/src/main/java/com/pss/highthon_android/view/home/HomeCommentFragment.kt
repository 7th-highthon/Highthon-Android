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

    fun clickBackBtn(view: View){
        mainViewModel.setActionView(true)
        this.findNavController().popBackStack()
    }

    private fun setComment(): ArrayList<String> {
        return arrayListOf("생일축하포카링~", "기모띠 야매떄~", "이거슨 예시", "킥킥스")
    }

    private fun setNickname(): ArrayList<String> {
        return arrayListOf("adfds~", "기모ewfe띠~", "aadsf예시", "asdfa")
    }

}