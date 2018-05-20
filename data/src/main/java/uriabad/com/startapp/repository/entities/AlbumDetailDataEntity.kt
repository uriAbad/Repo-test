package uriabad.com.startapp.repository.entities

import com.google.gson.annotations.SerializedName

data class AlbumDetailDataEntity(
        var id: String = "",
        var title: String = "",
        var type: String = "",
        var image: String = "",
        var duration: String = "",
        var available : Boolean = false,
        var releaseDate: String = "",
        var releaseYear: String = "",
        var label: LabelDataEntity,
        @SerializedName("pieces") var pieces: AlbumPiecesDetailDataEntity
)