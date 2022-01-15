package com.pss.highthon_android.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pss.highthon_android.R
import com.pss.highthon_android.base.BaseFragment
import com.pss.highthon_android.databinding.FragmentHomeBinding
import com.pss.highthon_android.databinding.FragmentHomeCommentBinding
import com.pss.highthon_android.view.home.adapter.HomeCommentRecyclerViewAdapter


class HomeFragment : BaseFragment<FragmentHomeCommentBinding>(R.layout.fragment_home_comment) {

    override fun init() {
    }

}