package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.ExploreInfo
import uriabad.com.startapp.network.appendHttpsPrefix
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.ExploreDataEntity

fun ExploreDataEntity.toExploreInfo(): ExploreInfo = ExploreInfo(
        id.safe(),
        type.safe(),
        title.safe(),
        subtitle.safe(),
        href.safe(),
        available.safe(),
        image.safe().appendHttpsPrefix(),
        score.safe())