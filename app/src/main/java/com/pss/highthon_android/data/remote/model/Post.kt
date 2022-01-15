package com.pss.highthon_android.data.remote.model

data class Post(
    val title:String,
    val content : String,
    val name : String,
    val date : String,
    val category: String
) {
    constructor() : this("오류","오류","오류","오류","오류")
}