package uriabad.com.startapp.model

data class PieceInfo(
        val id: String,
        val type: String,
        val title: String,
        val image: String,
        val piece: PieceSummaryInfo,
        val tracks: List<TrackInfo>,
        val composer: ComposerInfo,
        val artists: List<ArtistSummaryInfo>
)