package com.pss.highthon_android.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pss.highthon_android.data.remote.model.Post
import com.pss.highthon_android.repository.HomeRepository
import com.pss.highthon_android.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FAQViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
    val whatSelectFaq: LiveData<String> get() = _whatSelectFaq
    private val _whatSelectFaq = MutableLiveData<String>()

    val category : LiveData<String> get() = _category
    private val _category = MutableLiveData<String>()

    fun setFaq(faq : String){
        _whatSelectFaq.value = faq
    }

    fun setCategory(category: String){
        _category.value = category
        Log.d("cocopam",_category.value.toString())
    }

}
