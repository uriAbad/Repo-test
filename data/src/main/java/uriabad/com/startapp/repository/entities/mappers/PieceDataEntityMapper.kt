package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.PieceInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.PieceDataEntity

fun PieceDataEntity.toPieceInfo(): PieceInfo {
    return PieceInfo(this.id.safe(), this.type.safe(), this.title.safe(), this.image.safe(),
            this.piece.toPieceSummaryInfo(), this.tracks.map { it.toTrackInfo() },
            this.composer.toComposerInfo(), this.artists.map { it.toArtistSummaryInfo() })
}