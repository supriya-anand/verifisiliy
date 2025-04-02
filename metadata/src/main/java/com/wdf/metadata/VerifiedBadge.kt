package com.wdf.metadata

import android.content.Context
import android.net.Uri

class VerifiedBadge(private val context: Context) {
    private val verificationManager = VerificationManager()
    private val metadataExtractor = MetadataExtractor()

    fun applyVerification(imagePath: Uri, badgeView: BadgeView) {
        val metadata = metadataExtractor.extractMetadata(context , imagePath)
        val isVerified = verificationManager.isVerified(metadata)

        badgeView.setVerified(isVerified)  // Show/hide badge
    }
}
