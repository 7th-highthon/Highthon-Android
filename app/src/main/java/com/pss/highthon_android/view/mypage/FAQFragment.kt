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
import com.pss.highthon_android.databinding.FragmentFAQsBinding
import com.pss.highthon_android.databinding.FragmentMyPageBinding
import com.pss.highthon_android.viewmodel.FAQViewModel

class FAQFragment : BaseFragment<FragmentFAQsBinding>(R.layout.fragment_f_a_qs) {

    private val fAQViewModel by activityViewModels<FAQViewModel>()

    override fun init() {

        binding.backArrow.setOnClickListener {  this@FAQFragment.findNavController().popBackStack() }
        binding.textView8.setOnClickListener {
            fAQViewModel.setFaq("1")
            findNavController().navigate(R.id.action_FAQFragment_to_explainFragment)
        }
        binding.textView9.setOnClickListener {
            fAQViewModel.setFaq("2")
            findNavController().navigate(R.id.action_FAQFragment_to_explainFragment)
        }
        binding.textView10.setOnClickListener {
            fAQViewModel.setFaq("3")
            findNavController().navigate(R.id.action_FAQFragment_to_explainFragment)
        }

    }
}