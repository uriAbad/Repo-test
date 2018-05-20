package uriabad.com.startapp.repository.entities

import com.google.gson.annotations.SerializedName

data class TrackDataEntity(
        var id: String = "",
        var type: String = "",
        @SerializedName("movement_id") var movementId: String = "",
        var title: String = "",
        var available: Boolean = false,
        var isrc: String = "",
        var duration: Long = 0
)