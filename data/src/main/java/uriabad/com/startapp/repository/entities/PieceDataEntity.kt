package uriabad.com.startapp.repository.entities

import com.google.gson.annotations.SerializedName

data class PieceDataEntity(
        var id: String = "",
        var type: String = "",
        var title: String = "",
        var image: String = "",
        @SerializedName("piece") var piece: PieceSummaryDataEntity,
        @SerializedName("tracks") var tracks: List<TrackDataEntity>,
        @SerializedName("composer") var composer: ComposerDataEntity,
        @SerializedName("artists") var artists: List<ArtistSummaryDataEntity>
)