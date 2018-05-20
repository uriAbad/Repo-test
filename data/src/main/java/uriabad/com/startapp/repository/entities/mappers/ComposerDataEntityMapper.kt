package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.ComposerInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.ComposerDataEntity

fun ComposerDataEntity.toComposerInfo(): ComposerInfo {
    return ComposerInfo(this.id.safe(), this.type.safe(), this.name.safe())
}