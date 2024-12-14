package com.example.doctorappointmentapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorappointmentapp.Adapter.NearDoctorAdapter
import com.example.doctorappointmentapp.R
import com.example.doctorappointmentapp.ViewModel.MainViewModel
import com.example.doctorappointmentapp.databinding.ActivityMainBinding
import com.example.doctorappointmentapp.databinding.ViewholderNearbyBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initNearByDoctor()
        setupChipNavigationBar()

    }


    private fun initNearByDoctor() {
        binding.apply {
            progressBar6.visibility = View.VISIBLE
            viewModel.loadDoctors().observe(this@MainActivity,
                {
                    recyclerView.layoutManager =
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    recyclerView.adapter = NearDoctorAdapter(it)
                    progressBar6.visibility = View.GONE
                }

            )
        }
    }

    private fun setupChipNavigationBar() {
        // Set item selection listener for the ChipNavigationBar
        binding.chipNavigationBar.setOnItemSelectedListener { menuItemId ->
            when (menuItemId) {
                R.id.home -> {
                    // Handle Home navigation logic if needed
                }

                R.id.explore -> {
                    // Handle Explore navigation logic if needed
                }

                R.id.bookmark -> {
                    // Handle Bookmark navigation logic if needed
                }

                R.id.profile -> {
                    // Navigate to ProfileActivity
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
