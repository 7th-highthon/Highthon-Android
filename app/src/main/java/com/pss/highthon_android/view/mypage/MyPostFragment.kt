package com.pss.highthon_android.view.mypage

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.pss.highthon_android.R
import com.pss.highthon_android.base.BaseFragment
import com.pss.highthon_android.data.remote.model.MyPost
import com.pss.highthon_android.data.remote.model.Post
import com.pss.highthon_android.databinding.FragmentMyPageBinding
import com.pss.highthon_android.databinding.FragmentMyPostBinding
import com.pss.highthon_android.viewmodel.FAQViewModel

class MyPostFragment : BaseFragment<FragmentMyPostBinding>(R.layout.fragment_my_post) {

    private val fAQViewModel by activityViewModels<FAQViewModel>()

    override fun init() {

        val sAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.catagory, android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPost.setAdapter(sAdapter)

        setGrid()

        setSpinner()

    }

    private fun setGrid() {
        binding.recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = MypageAdapter(setDummy(),this, fAQViewModel)
    }

    private fun setSpinner() {
        binding.spinnerPost.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                fAQViewModel.setCategory( binding.spinnerPost.selectedItem.toString())
                setGrid()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    fun setDummy() : ArrayList<MyPost>{
        return arrayListOf(
            MyPost("이거슨 생일","2022/01/20","생일"),
            MyPost("니가생일이면 나도 생일이다.","2022/01/21","생일"),
            MyPost("니가생일이면 나도 생일이다람쥐.","2022/01/23","생일"),
            MyPost("솔직히 난 취업 했다 ㅋㅋ","2022/01/21","취업"),
            MyPost("공기업간다 ㅋㅋ","2022/01/18","취업"),
            MyPost("정들었던 학교를 떠나..","2021/11/20","졸업"),
            MyPost("정들었던 학교를 떠나가버린다..","2021/11/20","졸업"),
            MyPost("드디어 졸업한다..","2021/11/20","졸업"),
            MyPost("보고싶을거야","2021/11/20","졸업"),
            MyPost("너무 슬프다","2021/11/20","졸업"),
        )
    }

}