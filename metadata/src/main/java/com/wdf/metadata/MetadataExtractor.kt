package com.wdf.metadata

import android.content.Context
import android.net.Uri
import androidx.exifinterface.media.ExifInterface

class MetadataExtractor {
    fun extractMetadata(context: Context, imageUrl: Uri): Map<String, String>{
        return try {
            val inputStream = context.contentResolver.openInputStream(imageUrl)
            val exif = ExifInterface(inputStream!!)
            mapOf(
                "Make" to (exif.getAttribute(ExifInterface.TAG_MAKE) ?: "Unknown"),
                "Model" to (exif.getAttribute(ExifInterface.TAG_MODEL) ?: "Unknown"),
                "DateTime" to (exif.getAttribute(ExifInterface.TAG_DATETIME) ?: "Unknown")
            )
        }catch (e: Exception){
            emptyMap()
        }
    }

}