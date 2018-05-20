package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.ArtistSummaryInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.ArtistSummaryDataEntity

fun ArtistSummaryDataEntity.toArtistSummaryInfo(): ArtistSummaryInfo {
    return ArtistSummaryInfo(this.id.safe(), this.type.safe(), this.role.safe(), this.name.safe())
}