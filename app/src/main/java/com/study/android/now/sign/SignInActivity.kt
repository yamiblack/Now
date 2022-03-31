package com.study.android.now.sign

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.study.android.now.MainActivity
import com.study.android.now.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private val signViewModel: SignViewModel by viewModels()
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepVisibleCondition {
                signViewModel.isLoading.value
            }
        }

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}