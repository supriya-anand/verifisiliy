package com.wdf.metadata

import android.content.Context
//import android.support.v4.app.NotificationCompat.BadgeIconType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import javax.net.ssl.HostnameVerifier

class BadgeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val badgeIcon: ImageView
    private val badgeText: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.badge, this, true)

        badgeIcon = findViewById(R.id.badgeIcon)
        badgeText = findViewById(R.id.badgeText)

        setVerified(false) // Default state
    }

    fun setVerified(isVerified: Boolean) {
        if (isVerified) {
            badgeIcon.setImageResource(R.drawable.verified2)
            badgeText.text = "✔ Verified"
            badgeText.setTextColor(ContextCompat.getColor(context, android.R.color.holo_green_dark))
        } else {
            badgeIcon.setImageResource(R.drawable.delete1)
            badgeText.text = "❌ Not Verified"
            badgeText.setTextColor(ContextCompat.getColor(context, android.R.color.holo_red_dark))
        }
    }
}
