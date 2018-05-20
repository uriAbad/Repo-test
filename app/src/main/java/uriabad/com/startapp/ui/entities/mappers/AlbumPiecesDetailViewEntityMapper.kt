package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.AlbumPiecesDetailInfo
import uriabad.com.startapp.ui.entities.AlbumPiecesDetailViewEntity

fun AlbumPiecesDetailInfo.toAlbumPiecesDetailViewEntity(): AlbumPiecesDetailViewEntity {
    return AlbumPiecesDetailViewEntity(this.total, this.showMore,
            this.items.map { it.toPieceViewEntity() })
}