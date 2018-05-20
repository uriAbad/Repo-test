package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.AlbumInfo
import uriabad.com.startapp.ui.entities.AlbumViewEntity

fun AlbumInfo.toAlbumViewEntity(): AlbumViewEntity {
    return AlbumViewEntity (this.id, this.title, this.type, this.image, this.duration,
                            this.subtitle, this.available)
}