package uriabad.com.startapp.repository.entities

import uriabad.com.startapp.network.ApiConstants.Companion.MP3
import com.google.gson.annotations.SerializedName

data class PreferencesDataEntity(
        @SerializedName("notification_permission") var notificationPermission: Boolean = false,
        var quality : String = MP3,
        @SerializedName("auto_quality_selected") var autoQualitySelected: Boolean = false
)