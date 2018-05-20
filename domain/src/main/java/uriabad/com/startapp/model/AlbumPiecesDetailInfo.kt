package uriabad.com.startapp.model

data class AlbumPiecesDetailInfo(
        val total: String,
        val showMore: Boolean = false,
        val items: List<PieceInfo>
)