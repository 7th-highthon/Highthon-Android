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
import com.pss.highthon_android.databinding.FragmentExplainBinding
import com.pss.highthon_android.databinding.FragmentFAQsBinding
import com.pss.highthon_android.viewmodel.FAQViewModel

class ExplainFragment : BaseFragment<FragmentExplainBinding>(R.layout.fragment_explain) {

    private val fAQViewModel by activityViewModels<FAQViewModel>()

    override fun init() {

        binding.backArrow.setOnClickListener { this@ExplainFragment.findNavController().popBackStack() }

        when(fAQViewModel.whatSelectFaq.value){
            "1" -> {
                binding.textView10.setText(R.string.why_to_make_explain)
                binding.textView7.setText(R.string.why_to_make)
                binding.endTextview.setText(R.string.why_to_make_end)}
            "2" -> {
                binding.textView10.setText(R.string.how_to_use)
                binding.textView7.setText(R.string.how_to_easy)
                binding.endTextview.setText(R.string.how_to_easy_end)}
            "3" -> {
                binding.textView10.setText(R.string.who_make_explain)
                binding.textView7.setText(R.string.who_make)
                binding.endTextview.setText(R.string.who_make_end)}
            }
    }
}