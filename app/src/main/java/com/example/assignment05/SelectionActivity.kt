package com.example.assignment05

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment04.ImageAdapter

class SelectionActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

//        val displayImageView = findViewById<ImageView>(R.id.displayImageView)
//        val nameTextView = findViewById<TextView>(R.id.nameTextView)

        val images = arrayOf(
            ImageItem(R.drawable.android_01, "Lake"),
            ImageItem(R.drawable.android_02, "Daisies"),
            ImageItem(R.drawable.android_03, "Car light"),
            ImageItem(R.drawable.android_04, "RV trailer"),
            ImageItem(R.drawable.android_05, "Seaside road"),
            ImageItem(R.drawable.android_06, "Autumn leaves"),
            ImageItem(R.drawable.android_07, "Colorful houses"),
            ImageItem(R.drawable.android_08, "Road"),
            ImageItem(R.drawable.android_09, "Sunset"),
            ImageItem(R.drawable.android_10, "Grass")

        )

        val callback = { item: ImageItem ->
            val intent = Intent(this@SelectionActivity, DisplayActivity::class.java)
            intent.putExtra("IMAGE_ID", item.id)
            intent.putExtra("IMAGE_NAME", item.name)

            startActivity(intent)
        }


        recyclerView.adapter = ImageAdapter(images, callback)


        //recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}