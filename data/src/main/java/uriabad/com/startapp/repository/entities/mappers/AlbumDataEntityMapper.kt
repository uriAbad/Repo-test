package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.AlbumInfo
import uriabad.com.startapp.network.appendHttpsPrefix
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.network.toCompoundDuration
import uriabad.com.startapp.repository.entities.AlbumDataEntity


fun AlbumDataEntity.toAlbumInfo(): AlbumInfo {
    return AlbumInfo(this.id.safe(), this.title.safe(), this.type.safe(), this.image.safe().appendHttpsPrefix(),
            this.duration.safe().toCompoundDuration(), this.subtitle.safe(), this.available.safe())
}