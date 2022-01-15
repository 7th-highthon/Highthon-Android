package com.pss.highthon_android.viewmodel

import androidx.lifecycle.ViewModel
import com.pss.highthon_android.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {

}