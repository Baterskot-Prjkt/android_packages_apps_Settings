package com.android.settings.deviceinfo.firmwareversion

import android.content.Context
import android.os.SystemProperties
import com.android.settings.R
import com.android.settings.core.BasePreferenceController

class CustomMaintainerPreferenceController(context: Context, preferenceKey: String) :
    BasePreferenceController(context, preferenceKey) {

    companion object {
        private const val ROM_PROPERTY = "ro.custom.maintainer"
    }

    override fun getAvailabilityStatus(): Int {
        val maintainer = SystemProperties.get(ROM_PROPERTY, "")
        return if (maintainer.isNotEmpty()) AVAILABLE else UNSUPPORTED_ON_DEVICE
    }

    override fun getSummary(): CharSequence {
        val maintainer = SystemProperties.get(ROM_PROPERTY, "")
        return maintainer.ifEmpty { mContext.getString(R.string.device_info_default) }
    }
}