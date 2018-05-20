package uriabad.com.startapp.repository.entities

import com.google.gson.annotations.SerializedName

data class AlbumPiecesDetailDataEntity(
        var total: String = "",
        @SerializedName("showmore") var showMore: Boolean = false,
        @SerializedName("items") var items: List<PieceDataEntity>
)