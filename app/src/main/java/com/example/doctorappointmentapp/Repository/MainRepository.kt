package com.example.doctorappointmentapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctorappointmentapp.Model.DoctorModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainRepository {
    private val firebaseDatabase=FirebaseDatabase.getInstance()

    fun load():LiveData<MutableList<DoctorModel>>{
        val listData=MutableLiveData<MutableList<DoctorModel>>()
        val ref=firebaseDatabase.getReference("Doctors")

        ref.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists= mutableListOf<DoctorModel>()
                for(childSnapShot in snapshot.children){
                    val item = childSnapShot.getValue(DoctorModel::class.java)
                    item?.let{
                        lists.add(it)
                    }

                    listData.value=lists
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        return listData
    }
    }
