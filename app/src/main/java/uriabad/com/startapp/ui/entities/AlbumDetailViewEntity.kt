package uriabad.com.startapp.ui.entities

data class AlbumDetailViewEntity(
        val id: String,
        val title: String,
        val type: String,
        val image: String,
        val duration: String,
        val available : Boolean,
        val releaseDate: String,
        val releaseYear: String,
        val label: LabelViewEntity,
        val pieces: AlbumPiecesDetailViewEntity
)