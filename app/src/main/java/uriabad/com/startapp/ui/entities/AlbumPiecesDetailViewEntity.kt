package uriabad.com.startapp.ui.entities

data class AlbumPiecesDetailViewEntity(
        val total: String,
        val showMore: Boolean = false,
        val items: List<PieceViewEntity>
)