package com.example.mconnect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CarImageAdapter(private val images: List<Int>) : 
    RecyclerView.Adapter<CarImageAdapter.CarImageViewHolder>() {

    class CarImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(android.R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarImageViewHolder {
        val imageView = ImageView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            scaleType = ImageView.ScaleType.CENTER_CROP
        }
        return CarImageViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: CarImageViewHolder, position: Int) {
        holder.imageView.setImageResource(images[position])
    }

    override fun getItemCount(): Int = images.size
} 