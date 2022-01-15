package com.pss.highthon_android.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pss.highthon_android.data.remote.model.Post
import com.pss.highthon_android.repository.HomeRepository
import com.pss.highthon_android.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
    //게시물 가져오기 성공 이벤트
    val eventGetPostSuccess: LiveData<Any> get() = _eventGetPostSuccess
    private val _eventGetPostSuccess = SingleLiveEvent<Any>()

    //피드 게시물 클릭 이벤트
    val eventFeedClick: LiveData<Any> get() = _eventFeedClick
    private val _eventFeedClick = SingleLiveEvent<Any>()

    //사용자 카테고리 선택 이벤트
    val eventChoiceCategory: LiveData<String> get() = _eventChoiceCategory
    private val _eventChoiceCategory = SingleLiveEvent<String>()

    val postList = arrayListOf<Post>()


    //게시물 가져오기
    fun getPost() = homeRepository.getPost(_eventChoiceCategory.value!!)
        .addOnSuccessListener {
            postList.clear()
            for (item in it.documents) {
                item.toObject(Post::class.java).let {
                    postList.add(it!!)
                }
            }
            _eventGetPostSuccess.call()
        }
        .addOnFailureListener {

        }

    //유저가 선택한 카테고리
    fun setCategory(category : String) = _eventChoiceCategory.postValue(category)

    fun callEventFeedClick() = _eventFeedClick.call()
}