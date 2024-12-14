

package com.example.doctorappointmentapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.doctorappointmentapp.Activity.DetailActivity
import com.example.doctorappointmentapp.Model.DoctorModel
import com.example.doctorappointmentapp.databinding.ViewholderNearbyBinding

class NearDoctorAdapter(val items: MutableList<DoctorModel>) :
    RecyclerView.Adapter<NearDoctorAdapter.ViewHolder>() {

    private var context: Context? = null

    // ViewHolder class to hold the views for each item
    class ViewHolder(val binding: ViewholderNearbyBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        // Inflate the viewholder_nearby layout and return the ViewHolder
        val binding = ViewholderNearbyBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Set data to the views using the binding object
        val doctor = items[position]
        holder.binding.textView3.text=items[position].Name
        holder.binding.textView5.text=items[position].Special
        holder.binding.textView9.text=items[position].Cost

        // Use Glide to load the doctor's image
        Glide.with(holder.itemView.context)
            .load(doctor.Picture)
            .apply(RequestOptions().transform(CenterCrop()))
            .into(holder.binding.imageView5)

        holder.binding.root.setOnClickListener{
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("object",items[position])
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}
