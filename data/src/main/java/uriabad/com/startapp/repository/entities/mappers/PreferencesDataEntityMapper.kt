package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.PreferencesInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.PreferencesDataEntity

fun PreferencesDataEntity.toPreferencesInfo(): PreferencesInfo {
    return PreferencesInfo(this.notificationPermission.safe(), this.quality.safe(),
                           this.autoQualitySelected.safe())
}