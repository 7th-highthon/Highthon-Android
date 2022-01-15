package com.pss.highthon_android.view

import androidx.activity.viewModels
import com.pss.highthon_android.R
import com.pss.highthon_android.base.BaseActivity
import com.pss.highthon_android.databinding.ActivityMainBinding
import com.pss.highthon_android.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()


    override fun init() {

    }
}