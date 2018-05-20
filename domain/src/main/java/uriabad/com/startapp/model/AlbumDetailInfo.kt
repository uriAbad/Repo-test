package uriabad.com.startapp.model

data class AlbumDetailInfo(
        val id: String,
        val title: String,
        val type: String,
        val image: String,
        val duration: String,
        val available : Boolean,
        val releaseDate: String,
        val releaseYear: String,
        val label: LabelInfo,
        val pieces: AlbumPiecesDetailInfo
)