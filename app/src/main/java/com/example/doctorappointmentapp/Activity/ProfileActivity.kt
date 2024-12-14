package com.example.doctorappointmentapp.Activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.doctorappointmentapp.R
import com.example.doctorappointmentapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up profile details
        binding.apply {
            // Example data (replace with actual user data)
            profileName.text = "Rania Ijaz"
            profileEmail.text = "rania@example.com"
            profilePhone.text = "+123456789"
            profileAddress.text = "8502 Preston Rd, Inglewood, Maine 98380"
        }

        // Back button functionality
        binding.backButton.setOnClickListener {
            finish()
        }
    }
}
