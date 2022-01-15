package com.pss.highthon_android.repository

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val firebaseRtdb: FirebaseDatabase
) {
    fun getPost(category: String) = fireStore.collection("post").whereEqualTo("category", category).get()
}