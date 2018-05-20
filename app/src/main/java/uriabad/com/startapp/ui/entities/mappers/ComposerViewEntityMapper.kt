package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.ComposerInfo
import uriabad.com.startapp.ui.entities.ComposerViewEntity

fun ComposerInfo.toComposerViewEntity(): ComposerViewEntity {
    return ComposerViewEntity(this.id, this.type, this.name)
}