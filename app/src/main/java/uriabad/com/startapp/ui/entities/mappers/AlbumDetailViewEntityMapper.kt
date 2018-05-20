package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.AlbumDetailInfo
import uriabad.com.startapp.ui.entities.AlbumDetailViewEntity

fun AlbumDetailInfo.toAlbumDetailViewEntity(): AlbumDetailViewEntity {
    return AlbumDetailViewEntity(this.id, this.title, this.type, this.image, this.duration,
            this.available, this.releaseDate, this.releaseYear, this.label.toLabelViewEntity(),
            this.pieces.toAlbumPiecesDetailViewEntity())
}