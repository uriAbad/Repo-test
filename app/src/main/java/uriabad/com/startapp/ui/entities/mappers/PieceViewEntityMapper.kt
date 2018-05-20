package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.PieceInfo
import uriabad.com.startapp.ui.entities.PieceViewEntity

fun PieceInfo.toPieceViewEntity(): PieceViewEntity {
    return PieceViewEntity(this.id, this.type, this.title, this.image,
            this.piece.toPieceSummaryViewEntity(),
            this.tracks.map { it.toTrackViewEntity() },
            this.composer.toComposerViewEntity(),
            this.artists.map { it.toArtistSummaryViewEntity() })
}