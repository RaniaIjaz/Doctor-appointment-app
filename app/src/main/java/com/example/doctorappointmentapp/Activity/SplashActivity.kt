package com.example.doctorappointmentapp.Activity

import android.content.Intent
import android.os.Bundle
import com.example.doctorappointmentapp.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
       setContentView(binding.root)

        binding.apply {
            startBtn.setOnClickListener{
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
        }
    }
}