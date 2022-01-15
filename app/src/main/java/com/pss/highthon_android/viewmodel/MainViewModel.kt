package com.pss.highthon_android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pss.highthon_android.repository.MainRepository
import com.pss.highthon_android.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {
    //다른화면으로 넘어갈때 bottom nav bar 숨기기 or 보이기 (true = 보이기, false = 숨기기)
    val eventActionView: LiveData<Boolean> get() = _eventActionView
    private val _eventActionView = SingleLiveEvent<Boolean>()


    fun setActionView(content: Boolean) = _eventActionView.postValue(content)
}