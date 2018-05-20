package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.LabelInfo
import uriabad.com.startapp.ui.entities.LabelViewEntity

fun LabelInfo.toLabelViewEntity(): LabelViewEntity {
    return LabelViewEntity(this.id, this.name, this.href)
}