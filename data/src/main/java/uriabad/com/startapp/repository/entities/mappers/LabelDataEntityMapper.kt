package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.LabelInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.LabelDataEntity

fun LabelDataEntity.toLabelInfo(): LabelInfo {
    return LabelInfo(this.id.safe(), this.name.safe(), this.href.safe())
}