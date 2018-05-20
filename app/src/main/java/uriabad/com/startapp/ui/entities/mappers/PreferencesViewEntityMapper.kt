package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.PreferencesInfo
import uriabad.com.startapp.ui.entities.PreferencesViewEntity

fun PreferencesInfo.toPreferencesViewEntity(): PreferencesViewEntity {
    return PreferencesViewEntity(notificationPermission, quality, autoQualitySelected)
}

fun PreferencesViewEntity.toPreferencesInfo(): PreferencesInfo {
    return PreferencesInfo(notificationPermission, quality, autoQualitySelected)
}