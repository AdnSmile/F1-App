package com.vvwxx.bangkit.f1app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.vvwxx.bangkit.f1app.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // menghilangkan supportActionBar
        val action = supportActionBar
        action?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val moveIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(moveIntent)
            finish()
        }, 3000)
    }
}