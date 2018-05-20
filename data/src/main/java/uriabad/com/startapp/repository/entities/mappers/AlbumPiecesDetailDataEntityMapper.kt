package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.AlbumPiecesDetailInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.AlbumPiecesDetailDataEntity

fun AlbumPiecesDetailDataEntity.toAlbumPiecesDetailInfo(): AlbumPiecesDetailInfo {
    return AlbumPiecesDetailInfo(this.total.safe(), this.showMore.safe(), this.items.map { it.toPieceInfo() })
}