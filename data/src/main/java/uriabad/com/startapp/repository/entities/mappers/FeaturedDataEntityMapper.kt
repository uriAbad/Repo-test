package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.FeaturedInfo
import uriabad.com.startapp.network.appendHttpsPrefix
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.network.toCompoundDuration
import uriabad.com.startapp.repository.entities.FeaturedDataEntity

fun FeaturedDataEntity.toFeaturedInfo(): FeaturedInfo {
    return FeaturedInfo(this.id.safe(), this.type.safe(), this.title.safe(), this.subtitle.safe(),
            this.image.safe().appendHttpsPrefix(), this.duration.safe().toCompoundDuration(), this.href.safe(), this
            .available.safe())
}