package com.vvwxx.bangkit.f1app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vvwxx.bangkit.f1app.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // menghilangkan supportActionBar
        val action = supportActionBar
        action?.hide()
    }
}