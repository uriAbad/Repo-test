package uriabad.com.startapp.repository.entities.disk

import io.realm.RealmObject

open class PreferencesDiskEntity(
        var notificationPermission: Boolean = false,
        var quality : String = "",
        var autoQualitySelected: Boolean = false
) : RealmObject()