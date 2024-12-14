package com.example.doctorappointmentapp.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.doctorappointmentapp.Model.DoctorModel
import com.example.doctorappointmentapp.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity() {
    private  lateinit var binding:ActivityDetailBinding
    private lateinit var item:DoctorModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundle()
    }

    private fun getBundle(){
        item=intent.getParcelableExtra("object")!!

        binding.apply {
            textName.text=item.Name
            textSpeciality.text=item.Special
            textPatient.text=item.Patiens
            bio.text=item.Biography
            textAddress.text=item.Address
            textTime.text=item.Time
            textDate.text=item.Date

            textExperience.text=item.Expriense.toString() + " Years"
            star.text="${item.Rating}"
            backbtn.setOnClickListener{
                finish()
            }
            website.setOnClickListener {
               val i = Intent(Intent.ACTION_VIEW)
                i.setData(Uri.parse(item.Site))
                startActivity(i)
            }

            message.setOnClickListener {
                val uri = Uri.parse("smsto:${item.Mobile}")
                val intent = Intent(Intent.ACTION_SEND,uri)
                intent.putExtra("sms_body","the SMS text")
                startActivity(intent)
            }

            call.setOnClickListener {
                val uri = "tel:" +item.Mobile.trim()
                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse(uri)
                )
                startActivity(intent)
            }

            direction.setOnClickListener {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(item.Location)
                )
                startActivity(intent)
            }

            share.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_SUBJECT,item.Name)
                intent.putExtra(
                    Intent.EXTRA_TEXT,
                    item.Name + "  "  + item.Address + " " + item.Mobile
                )
                startActivity(Intent.createChooser(intent,"Choose one"))
            }
            Glide.with(this@DetailActivity)
                .load(item.Picture)
                .into(doctorPic)
        }

        binding.btnApointment.setOnClickListener {
            val intent = Intent(this@DetailActivity, MakeAppointmentActivity::class.java)
            startActivity(intent)
        }


    }
}