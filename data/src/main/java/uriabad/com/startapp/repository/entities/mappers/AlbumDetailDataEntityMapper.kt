package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.AlbumDetailInfo
import uriabad.com.startapp.network.appendHttpsPrefix
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.network.toCompoundDuration
import uriabad.com.startapp.repository.entities.AlbumDetailDataEntity

fun AlbumDetailDataEntity.toAlbumDetailInfo(): AlbumDetailInfo {
    return AlbumDetailInfo(this.id.safe(), this.title.safe(), this.type.safe(),
            this.image.safe().appendHttpsPrefix(), this.duration.safe().toCompoundDuration(),
            this.available.safe(), this.releaseDate.safe(), this.releaseYear.safe(), this.label
            .toLabelInfo(), this.pieces.toAlbumPiecesDetailInfo())
}