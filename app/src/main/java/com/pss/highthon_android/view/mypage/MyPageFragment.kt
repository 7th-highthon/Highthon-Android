package com.pss.highthon_android.view.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.pss.highthon_android.R
import com.pss.highthon_android.base.BaseFragment
import com.pss.highthon_android.databinding.FragmentMyPageBinding
import com.pss.highthon_android.viewmodel.FAQViewModel
import com.pss.highthon_android.viewmodel.HomeViewModel


class MyPageFragment : BaseFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {


    override fun init() {
        binding.faqTextview.setOnClickListener { findNavController().navigate(R.id.action_myPageFragment_to_FAQFragment) }
        binding.textView5.setOnClickListener { findNavController().navigate(R.id.action_myPageFragment_to_myPostFragment) }
    }
    }