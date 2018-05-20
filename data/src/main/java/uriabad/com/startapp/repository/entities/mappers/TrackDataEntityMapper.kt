package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.TrackInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.network.toCompoundDuration
import uriabad.com.startapp.repository.entities.TrackDataEntity

fun TrackDataEntity.toTrackInfo(): TrackInfo {
    return TrackInfo(this.id.safe(), this.type.safe(), this.movementId.safe(),
            this.title.safe(), this.available.safe(), this.isrc.safe(),
            this.duration.safe().toCompoundDuration())
}