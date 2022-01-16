package com.pss.highthon_android.view.login

import android.content.Intent
import android.graphics.Color
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pss.barlibrary.CustomBar
import com.pss.highthon_android.R
import com.pss.highthon_android.base.BaseActivity
import com.pss.highthon_android.databinding.ActivityLoginBinding
import com.pss.highthon_android.view.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    // 로그인 결과 Response
    private val RC_SIGN_IN = 9001
    // 구글 API 계정
    private var googleSignInClient: GoogleSignInClient? = null
    // 파이어베이스 Auth
    private var firebaseAuth: FirebaseAuth? = null

    override fun init() {
        firebaseAuth = Firebase.auth
        CustomBar.setContrastBar(this, Color.parseColor("#FFFFFF"))
        updateUI(firebaseAuth!!.currentUser)
        login()
        onBackPressed()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // 구글 로그인 응답
        if(requestCode === RC_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // 성공 시 firebase 연동
                val account = task.getResult(ApiException::class.java)
                Log.d("LoginActivity","firebaseAuthWithGoogle: " + account.id)
                firebaseAuthWithGoogle(account)
            }catch (e: ApiException){
                Log.e("LoginActivity","Google sign in failed", e)
            }
        }
    }

    private fun login(){
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.test_web_client_id))
            .requestEmail()
            .build()

        // requestIdToken 호출
        googleSignInClient = GoogleSignIn.getClient(this,gso)
        // auth의 인스턴스 호출
        firebaseAuth = FirebaseAuth.getInstance()

        binding.googleLoginButton.setOnClickListener{
            val signInIntent = googleSignInClient?.signInIntent
            startActivityForResult(signInIntent,RC_SIGN_IN)
        }
    }
    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount){
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        Log.d("LoginActivity","${acct.idToken}") // 토큰 생성
        firebaseAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    val user = firebaseAuth?.currentUser
                    updateUI(user)
                    shortShowToast("로그인에 성공했습니다")
                }else{
                    Log.w("LoginActivity","${it.exception}")
                    updateUI(null)
                    shortShowToast("로그인에 실패했습니다")
                }
            }
    }
    private fun updateUI(user: FirebaseUser?) {
        if(user != null){
            startActivity(Intent(this,MainActivity::class.java))
            overridePendingTransition(0,0)
            finish()
        }
    }
}