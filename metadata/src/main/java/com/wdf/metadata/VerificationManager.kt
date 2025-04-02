package com.wdf.metadata

class VerificationManager{
    fun isVerified(metadata: Map<String, String>): Boolean{
        return metadata["Make"] == "Canon" && metadata["DateTime"] != "22012025"
    }
}