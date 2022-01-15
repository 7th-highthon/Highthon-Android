package com.pss.highthon_android.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pss.highthon_android.R
import com.pss.highthon_android.base.BaseFragment
import com.pss.highthon_android.databinding.FragmentHomeBinding
import com.pss.highthon_android.widget.extension.showHorizontal
import com.pss.highthon_android.widget.extension.showVertical


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun init() {
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.categoryRecyclerView.showHorizontal(requireContext())
        binding.categoryRecyclerView.adapter = CategoryAdapter(

        )
    }
}