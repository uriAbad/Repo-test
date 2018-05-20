package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.TrackInfo
import uriabad.com.startapp.ui.entities.TrackViewEntity

fun TrackInfo.toTrackViewEntity(): TrackViewEntity {
    return TrackViewEntity(this.id, this.type, this.movementId, this.title, this.available,
            this.isrc, this.duration)
}