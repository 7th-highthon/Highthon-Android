package com.pss.highthon_android.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.pss.highthon_android.R
import com.pss.highthon_android.base.BaseFragment
import com.pss.highthon_android.databinding.FragmentHomeBinding
import com.pss.highthon_android.viewmodel.HomeViewModel
import com.pss.highthon_android.viewmodel.MainViewModel
import com.pss.highthon_android.widget.extension.showHorizontal
import com.pss.highthon_android.widget.extension.showVertical


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val homeViewModel by activityViewModels<HomeViewModel>()
    private val mainViewModel by activityViewModels<MainViewModel>()


    override fun init() {
        observeViewModel()
        homeViewModel.setCategory("birthday")
    }

    private fun initRecyclerView(){
        binding.categoryRecyclerView.showHorizontal(requireContext())
        binding.categoryRecyclerView.adapter = CategoryAdapter(homeViewModel)
    }

    private fun observeViewModel(){
        homeViewModel.eventGetPostSuccess.observe(this,{
            initViewPager()
        })

        homeViewModel.eventChoiceCategory.observe(this,{
            initRecyclerView()
            homeViewModel.getPost()
        })

        homeViewModel.eventFeedClick.observe(this,{
            this.findNavController().navigate(R.id.action_homeFragment_to_homeCommentFragment)
            mainViewModel.setActionView(false)
        })
    }

    private fun initViewPager() {
        //val imgList = arrayListOf<Int>(R.drawable.first, R.drawable.second, R.drawable.third)
        with(binding.feedViewPager2) {
            adapter = FeedViewPagerAdapter(homeViewModel)
            setPadding(30, 0, 30, 0)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }
            })
        }
    }
}