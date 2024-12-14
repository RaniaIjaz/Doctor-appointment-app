package com.example.doctorappointmentapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.doctorappointmentapp.Model.DoctorModel
import com.example.doctorappointmentapp.Repository.MainRepository

class MainViewModel():ViewModel() {
    private val repository = MainRepository()

    fun loadDoctors():LiveData<MutableList<DoctorModel>>{
        return repository.load()
    }
}