package com.example.assignment05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val imageId = intent.getIntExtra("IMAGE_ID", 0)
        val imageName = intent.getStringExtra("IMAGE_NAME")
        with(findViewById<TextView>(R.id.textView)) {

            text = imageName
        }

        with(findViewById<ImageView>(R.id.imageView)) {
            setImageResource(imageId)
        }
        findViewById<Button>(R.id.button).setOnClickListener {
            finish()
        }
    }
}