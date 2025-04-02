package com.wdf.verifymybadge


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import com.wdf.metadata.VerifiedBadge
import com.wdf.metadata.BadgeView
import android.net.Uri
import android.util.Log
import java.io.File
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageUrl = "https://imgur.com/gallery/thats-long-url-dEpG6V0#/t/url"

//        val imageUri: Uri = Uri.fromFile(File(imagePath))

        val badgeView = findViewById<BadgeView>(R.id.badgeView)
        val imageView = findViewById<ImageView>(R.id.imageView)

        val verifiedBadge = VerifiedBadge(this)

        // Use Glide to load the image into the ImageView
        Glide.with(this)
            .load(imageUrl)
            .into(imageView)  // Assuming BadgeView is a subclass of ImageView

        // Convert imageUrl to Uri for verification
        val imageUri = Uri.parse(imageUrl)
        println("test test:_______")
        print(imageUri)

        verifiedBadge.applyVerification(imageUri, badgeView)
    }
}