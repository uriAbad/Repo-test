package uriabad.com.startapp.repository.entities.disk

import io.realm.RealmObject

open class SubscriptionDiskDataEntity (
        var product: String = "",
        var active : Boolean = false,
        var trial : Boolean = false,
        var status : String = "",
        var paydate : String = ""
) : RealmObject()