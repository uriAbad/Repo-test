package uriabad.com.startapp.repository.entities.disk.mapper

import uriabad.com.startapp.repository.entities.PreferencesDataEntity
import uriabad.com.startapp.repository.entities.disk.PreferencesDiskEntity

fun PreferencesDiskEntity.toPreferencesDataEntity(): PreferencesDataEntity {
    return PreferencesDataEntity(notificationPermission, quality, autoQualitySelected)
}

fun PreferencesDataEntity.toPreferencesDiskEntity(): PreferencesDiskEntity {
    return PreferencesDiskEntity(notificationPermission, quality, autoQualitySelected)
}