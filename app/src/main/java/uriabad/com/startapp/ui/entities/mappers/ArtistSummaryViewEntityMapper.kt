package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.ArtistSummaryInfo
import uriabad.com.startapp.ui.entities.ArtistSummaryViewEntity

fun ArtistSummaryInfo.toArtistSummaryViewEntity(): ArtistSummaryViewEntity {
    return ArtistSummaryViewEntity(this.id, this.type, this.role, this.name)
}