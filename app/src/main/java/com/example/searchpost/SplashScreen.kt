package com.example.searchpost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.searchpost.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showSplashImg()
    }

    private fun showSplashImg() {
        Glide.with(this).load(R.drawable.posta).into(binding.splashImg)
        binding.splashImg.alpha = 0f
        binding.splashImg.animate().setDuration(3000).alpha(1f).withEndAction {
            val intent = Intent()
            intent.apply {
                setClass(this@SplashScreen, MainActivity::class.java)
            }
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

    }
}
