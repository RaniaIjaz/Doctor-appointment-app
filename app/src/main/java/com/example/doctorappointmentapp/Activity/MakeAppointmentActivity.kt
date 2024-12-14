package com.example.doctorappointmentapp.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.doctorappointmentapp.databinding.ActivityMakeAppointmentBinding

class MakeAppointmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMakeAppointmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakeAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.confirmAppointment.setOnClickListener {
            val name = binding.patientName.text.toString()
            val date = binding.appointmentDate.text.toString()
            val time = binding.appointmentTime.text.toString()

            if (name.isNotEmpty() && date.isNotEmpty() && time.isNotEmpty()) {
                // Simulate storing appointment in database
                Toast.makeText(
                    this,
                    "Appointment Confirmed for $name on $date at $time",
                    Toast.LENGTH_LONG
                ).show()

                // Close the activity
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
