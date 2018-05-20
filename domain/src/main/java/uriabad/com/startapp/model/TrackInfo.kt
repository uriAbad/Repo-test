package uriabad.com.startapp.model

data class TrackInfo(
        val id: String,
        val type: String,
        val movementId: String,
        val title: String,
        val available: Boolean,
        val isrc: String,
        val duration: String
)