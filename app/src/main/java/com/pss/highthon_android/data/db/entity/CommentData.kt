package com.pss.highthon_android.data.db.entity

import com.google.gson.annotations.SerializedName

data class CommentData (
    @SerializedName("nickname")
    val nickname : String,
    @SerializedName("comment")
    val comment : String
)