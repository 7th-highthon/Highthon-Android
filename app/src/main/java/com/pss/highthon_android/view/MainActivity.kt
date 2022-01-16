package com.pss.highthon_android.view

import android.graphics.Color
import androidx.activity.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pss.barlibrary.CustomBar.Companion.setContrastBar
import com.pss.highthon_android.R
import com.pss.highthon_android.base.BaseActivity
import com.pss.highthon_android.databinding.ActivityMainBinding
import com.pss.highthon_android.viewmodel.MainViewModel
import com.pss.highthon_android.widget.extension.setVisibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()


    override fun init() {
        setContrastBar(this, Color.parseColor("#FFFFFF"))
        initBottomNavBar()
        observeViewModel()
    }

    private fun observeViewModel() {
        mainViewModel.eventActionView.observe(this, {
            when (it) {
                true -> binding.bottomNav.setVisibility(true)
                false -> binding.bottomNav.setVisibility(false)
            }
        })
    }

    private fun initBottomNavBar() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.nav_host)?.findNavController()
        val nav = binding.bottomNav as BottomNavigationView
        navController?.let {
            nav.setupWithNavController(navController)
        }
    }
}