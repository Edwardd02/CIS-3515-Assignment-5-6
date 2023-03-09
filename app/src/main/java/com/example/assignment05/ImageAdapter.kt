package com.example.assignment04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment05.ImageItem
import com.example.assignment05.R

class ImageAdapter(_imageItems : Array<ImageItem>, _callback : (ImageItem)->Unit) : RecyclerView.Adapter<ImageAdapter.ImageItemViewHolder>()
{
    private val imageItems = _imageItems
    private val callback = _callback
    inner class ImageItemViewHolder(layout : View) : RecyclerView.ViewHolder(layout)
    {
        val imageView = layout.findViewById<ImageView>(R.id.imageView)
        val textView = layout.findViewById<TextView>(R.id.textView)

        init{
            imageView.setOnClickListener{callback(imageItems[adapterPosition])}
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageItemViewHolder {
        return ImageItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_mian_display, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return imageItems.size
    }

    override fun onBindViewHolder(holder: ImageItemViewHolder, position: Int) {
        holder.imageView.setImageResource(imageItems[position].id)
        holder.textView.text = imageItems[position].name
    }
    /* private val images = _images

     class ImageViewHolder(_imageView : ImageView) : RecyclerView.ViewHolder(_imageView)
     {
         val imageView = _imageView

     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
         return ImageViewHolder(
             ImageView(parent.context
             ).apply {
                 layoutParams = ViewGroup.LayoutParams(300, 300)
             }
         )
     }

     override fun getItemCount(): Int {
         return images.size
     }

     override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
         holder.imageView.setImageResource(images[position])

     }*/
}